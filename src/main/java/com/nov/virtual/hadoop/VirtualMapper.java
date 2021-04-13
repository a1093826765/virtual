//package com.nov.virtual.hadoop;
//
//import cn.hutool.core.date.DateUtil;
//import com.nov.virtual.config.HadoopConfig;
//import org.apache.hadoop.io.IntWritable;
//import org.apache.hadoop.io.LongWritable;
//import org.apache.hadoop.io.Text;
//import org.apache.hadoop.mapreduce.Mapper;
//
//import java.io.IOException;
//import java.util.Date;
//
///**
// * Created by IntelliJ IDEA.
// *
// * @Description:
// * @Author: november
// * @CreateTime: 2021/4/2 5:51 下午
// * @UpdateTIme:
// */
//public class VirtualMapper extends Mapper<LongWritable, Text,IntWritable, VirtualData> {
//    VirtualData virtualData=new VirtualData();
//    IntWritable text=new IntWritable();
//    int textKey=0;
//    String line;
//    String[] split;
//    int i;
//    String close;
//
//    @Override
//    protected void setup(Context context) throws IOException, InterruptedException {
//        super.setup(context);
//    }
//
//
//    /**
//     *
//     * Created by IntelliJ IDEA.
//     * @Description: 对比数据
//     * @author november
//     * @CreateTime: 2021/4/6 10:40 上午
//     * @UpdateTIme:
//     * @param
//     * @return
//     */
//    @Override
//    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
//        //获取每一行数据
//        line=value.toString();
//        split = line.split(",");
//        //去除每行数据没用的东西
//        for(i=0;i<split.length;i++) {
//            split[i]=split[i].replaceAll("\\[","").replaceAll("]","").replaceAll("\"","");
//            if((i+1)%6==0){
//                //对比大小，设置key
//                close=split[i-1];
//                if(Double.parseDouble(close)> HadoopConfig.NOW_MONEY){
//                    textKey=1;
//                }else {
//                    textKey=0;
//                }
//                text.set(textKey);
//                Date date = DateUtil.parse(split[i-5], "yyyy-MM-dd");
//                virtualData.setDataTime(date.toString().substring(0,date.toString().indexOf(" ")));
//                virtualData.setKey(textKey);
//                virtualData.setOpen(split[i-4]);
//                virtualData.setHigh(split[i-3]);
//                virtualData.setLow(split[i-2]);
//                virtualData.setClose(close);
//                virtualData.setVolume(split[i]);
//                context.write(text,virtualData);
//            }
//        }
//    }
//
//    @Override
//    public void run(Context context) throws IOException, InterruptedException {
//        super.run(context);
//    }
//
//    @Override
//    protected void cleanup(Context context) throws IOException, InterruptedException {
//        super.cleanup(context);
//    }
//}
