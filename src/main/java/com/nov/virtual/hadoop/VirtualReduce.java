//package com.nov.virtual.hadoop;
//
//import org.apache.hadoop.io.DoubleWritable;
//import org.apache.hadoop.io.IntWritable;
//import org.apache.hadoop.mapreduce.Reducer;
//
//import java.io.IOException;
//
///**
// * Created by IntelliJ IDEA.
// *
// * @Description:
// * @Author: november
// * @CreateTime: 2021/4/2 5:51 下午
// * @UpdateTIme:
// */
//public class VirtualReduce extends Reducer<IntWritable, VirtualData, IntWritable,DoubleWritable> {
//    Double OneSum=0d;
//    Double TwoSum=0d;
//    DoubleWritable doubleWritable=new DoubleWritable();
//    Double size=0d;
//
//    @Override
//    protected void setup(Context context) throws IOException, InterruptedException {
//        super.setup(context);
//    }
//
//    @Override
//    protected void reduce(IntWritable key, Iterable<VirtualData> values, Context context) throws IOException, InterruptedException {
//        if(key.get()==0){
//            for (VirtualData virtualData:values){
//                OneSum++;
//            }
//        }else if(key.get()==1){
//            for (VirtualData virtualData:values){
//                TwoSum++;
//            }
//        }
//    }
//
//    @Override
//    protected void cleanup(Context context) throws IOException, InterruptedException {
//        size=OneSum+TwoSum;
//        doubleWritable.set(OneSum/size);
//        context.write(new IntWritable(0),doubleWritable);
//        doubleWritable.set(TwoSum/size);
//        context.write(new IntWritable(1),doubleWritable);
//        super.cleanup(context);
//    }
//
//    @Override
//    public void run(Context context) throws IOException, InterruptedException {
//        super.run(context);
//    }
//}
