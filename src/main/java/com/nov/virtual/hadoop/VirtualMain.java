package com.nov.virtual.hadoop;

import com.nov.virtual.service.CommandService;
import com.nov.virtual.service.FileService;
import com.nov.virtual.service.OkExService;
import com.nov.virtual.config.HadoopConfig;
import com.nov.virtual.shop.okEx.okcoin.commons.okex.open.api.client.ApiHttp;
import com.nov.virtual.shop.okEx.okcoin.commons.okex.open.api.config.APIConfiguration;
import com.nov.virtual.sql.model.Currency;
import com.nov.virtual.sql.model.CurrencyExample;
import com.nov.virtual.sql.service.CurrencyService;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Description:
 * @Author: november
 * @CreateTime: 2021/4/2 5:36 下午
 * @UpdateTIme:
 */
@Component
@Configurable
@EnableScheduling
@Slf4j
public class VirtualMain extends Configured implements Tool {

    @Autowired
    FileService fileService;

    @Autowired
    CommandService commandService;

    @Autowired
    CurrencyService currencyService;

    @Autowired
    OkExService okExService;


    public static void main(String[] args) throws Exception {
        String[] currencys = {"ETH","BTC","ADA", "LTC", "XRP"};
        for(String str:currencys){
            ApiHttp apiHttp=new ApiHttp(new APIConfiguration("https://www.okex.com"),new OkHttpClient());
            String result=apiHttp.get("/api/spot/v3/instruments/"+str+"-USDT/ticker");
            System.out.println(result);
            HadoopConfig.NOW_MONEY=0.0;
            args=new String[]{"/Users/november/Desktop/hadoop/"+str+".txt","/Users/november/Desktop/virtual/"+str+"B.txt"};
            int exitCode = ToolRunner.run(new VirtualMain(), args);
        }


    }

    @Scheduled(fixedRate = 1000 * 1800)
    public void test(){
        try {
            System.out.println("=============");
            //查询所有货币
            List<Currency> currencyList = currencyService.getCurrencyByExample(new CurrencyExample());
            String newMoney;
            for(Currency currency:currencyList) {
                String[] args=new String[]{"/Users/november/Desktop/virtualData.txt","/Users/november/Desktop/file/test/out9"+currency.getCurrencyname()};
                //查询最新的价格
                newMoney = okExService.getNewMoney(currency.getCurrencyname());
                HadoopConfig.NOW_MONEY=Double.parseDouble(newMoney);
                //删除文件，保证hadoop正常运行
                boolean delete = fileService.delete("/Users/november/Desktop/file/test/out9" + currency.getCurrencyname());
                log.info("文件:{}删除:{}",currency.getCurrencyname(),delete);
                ToolRunner.run(new VirtualMain(), args);
                log.info(currency.getCurrencyname()+"更新成功");
            }
        }catch (Exception e){
            e.printStackTrace();
            log.error("hadoop报错",e);
        }
    }

    /**
     *
     * Created by IntelliJ IDEA.
     * @Description: 每天更新一次
     * @author november
     * @CreateTime: 2021/4/6 5:18 下午
     * @UpdateTIme:
     * @param
     * @return
     */
    @Scheduled(cron = "0 0 0 * * * ")
    public void updateFile(){
        try {
            String url;
            ApiHttp apiHttp = new ApiHttp(new APIConfiguration("https://www.okex.com"), new OkHttpClient());
            //查询所有货币
            List<Currency> currencyList = currencyService.getCurrencyByExample(new CurrencyExample());
            for (Currency currency : currencyList) {
                url = "/api/spot/v3/instruments/" + currency.getCurrencyname() + "-USDT/candles?granularity=3600";
                String result = apiHttp.get(url);
                //追加数据
                fileService.updateTxtFile(currency.getCurrencyname() + ".txt", result, HadoopConfig.HADOOP_INPUT_FILE, true);
                log.info("追加数据成功:{}",currency.getCurrencyname());
            }
        }catch (Exception e){
            e.printStackTrace();
            log.error("文件更新失败",e);
        }
    }

    /**
     *
     * Created by IntelliJ IDEA.
     * @Description: 每半小时执行一次 更新策略数据
     * @author november
     * @CreateTime: 2021/4/6 3:17 下午
     * @UpdateTIme:
     * @param
     * @return
     */
    @Scheduled(cron = "0 0 * * * * ")
    public void runHadoop(){
        try {
            String[] args;
            //查询所有货币
            List<Currency> currencyList = currencyService.getCurrencyByExample(new CurrencyExample());
            String newMoney;
            for(Currency currency:currencyList) {
                args = new String[]{HadoopConfig.HADOOP_INPUT_FILE+currency.getCurrencyname()+".txt", HadoopConfig.HADOOP_OUTPUT_FILE+currency.getCurrencyname()};
                //查询最新的价格
                newMoney = okExService.getNewMoney(currency.getCurrencyname());
                HadoopConfig.NOW_MONEY=Double.parseDouble(newMoney);
                //删除文件，保证hadoop正常运行
                fileService.delete(HadoopConfig.HADOOP_OUTPUT_FILE);
                ToolRunner.run(new VirtualMain(), args);
//                commandService.executeCmd("cp -rf "+HadoopConfig.HADOOP_OUTPUT_FILE+" "+HadoopConfig.CP_OUTPUT_FILE+currency.getCurrencyname()+".txt");
                log.info(currency.getCurrencyname()+"更新成功");
            }
        }catch (Exception e){
            e.printStackTrace();
            log.error("hadoop报错",e);
        }
    }

    private SimpleDateFormat dateFormat() {
        return new SimpleDateFormat("HH:mm:ss");
    }

    @Override
    public int run(String[] strings) throws Exception {
        Configuration configuration = new Configuration();
        //如果在linux上执行，已经配置hadoop则不需要配置
//        configuration.set("mapreduce.framework.name","yarn");
////        configuration.set("yarn.resoucemanager.hostname","bigdata1");
        configuration.set("mapreduce.framework.name","local");
        configuration.set("fs.defaultFS","file:///");
        Job job = Job.getInstance(configuration);

        //指定本程序jar所在路径
        job.setJarByClass(VirtualMain.class);

        //指定本业务job使用的mapper和reducer的业务类
        job.setMapperClass(VirtualMapper.class);
        job.setReducerClass(VirtualReduce.class);

        //指定mapper输出数据的类型
        job.setMapOutputKeyClass(IntWritable.class);
        job.setMapOutputValueClass(VirtualData.class);

        //如果不设置，默认使用TextInputFormatClass.class
        //多个小文件分区使用，可以优化速度，用过合并多个小文件的分区方法
//        job.setInputFormatClass(CombineTextInputFormat.class);
//        CombineTextInputFormat.setMaxInputSplitSize(job,4194304);
//        CombineTextInputFormat.setMinInputSplitSize(job,2097152);

        //指定最终输出数据的kv类型（有reducer就是reducer的输出，没有reducer就是mapper的输出）
        job.setOutputKeyClass(IntWritable.class);
        job.setOutputValueClass(DoubleWritable.class);

        //在此设置自定义的WritableComparator类
//        job.setGroupingComparatorClass(PWritableComparator.class);
        //在此设置自定义的partitioner类
//        job.setPartitionerClass(PPartitioner.class);

        // 要控制不同的内容写往不同的目标路径，可以采用自定义outputFormat的方法
//        job.setOutputFormatClass(PFileOutputFormat.class);

        // 设置inputFormat
//        job.setInputFormatClass(PFileInputFormat.class);

        //设置分区数量
        job.setNumReduceTasks(1);

        //指定job输入的原始文件目录
        FileInputFormat.setInputPaths(job,new Path(strings[0]));
        //指定job输出结果的所在目录，必须输出一个_success文件，所以在此还需要设置输出path
        FileOutputFormat.setOutputPath(job,new Path(strings[1]));

        //将job中配置的相关配置，以及job所用的java类所在的jar包，提交给yarn运行
//        job.submit();//此方法并不知道程序的运行情况
        return  job.waitForCompletion(true) ? 0 : 1;
    }
}
