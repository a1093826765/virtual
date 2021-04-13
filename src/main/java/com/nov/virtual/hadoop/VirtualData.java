//package com.nov.virtual.hadoop;
//
//import lombok.Data;
//import org.apache.hadoop.io.WritableComparable;
//
//import java.io.DataInput;
//import java.io.DataOutput;
//import java.io.IOException;
//
///**
// * Created by IntelliJ IDEA.
// *
// * @Description:
// * @Author: november
// * @CreateTime: 2021/4/2 6:05 下午
// * @UpdateTIme:
// */
//@Data
//public class VirtualData  implements WritableComparable<VirtualData> {
//
//    /**
//     * 用于比较大小
//     * 小于为 0
//     * 大于为 1
//     */
//    private Integer key;
//
//    /**
//     * 货币价格时间
//     */
//    private String dataTime;
//
//    /**
//     * 开市价格
//     */
//    private String open;
//
//    /**
//     * 最高价格
//     */
//    private String high;
//
//    /**
//     * 最低价格
//     */
//    private String low;
//
//    /**
//     * 收市价格
//     */
//    private String close;
//
//    /**
//     * 成交量
//     */
//    private String volume;
//
//
//    /**
//     * Compares this object with the specified object for order.  Returns a
//     * negative integer, zero, or a positive integer as this object is less
//     * than, equal to, or greater than the specified object.
//     *
//     * <p>The implementor must ensure <tt>sgn(x.compareTo(y)) ==
//     * -sgn(y.compareTo(x))</tt> for all <tt>x</tt> and <tt>y</tt>.  (This
//     * implies that <tt>x.compareTo(y)</tt> must throw an exception iff
//     * <tt>y.compareTo(x)</tt> throws an exception.)
//     *
//     * <p>The implementor must also ensure that the relation is transitive:
//     * <tt>(x.compareTo(y)&gt;0 &amp;&amp; y.compareTo(z)&gt;0)</tt> implies
//     * <tt>x.compareTo(z)&gt;0</tt>.
//     *
//     * <p>Finally, the implementor must ensure that <tt>x.compareTo(y)==0</tt>
//     * implies that <tt>sgn(x.compareTo(z)) == sgn(y.compareTo(z))</tt>, for
//     * all <tt>z</tt>.
//     *
//     * <p>It is strongly recommended, but <i>not</i> strictly required that
//     * <tt>(x.compareTo(y)==0) == (x.equals(y))</tt>.  Generally speaking, any
//     * class that implements the <tt>Comparable</tt> interface and violates
//     * this condition should clearly indicate this fact.  The recommended
//     * language is "Note: this class has a natural ordering that is
//     * inconsistent with equals."
//     *
//     * <p>In the foregoing description, the notation
//     * <tt>sgn(</tt><i>expression</i><tt>)</tt> designates the mathematical
//     * <i>signum</i> function, which is defined to return one of <tt>-1</tt>,
//     * <tt>0</tt>, or <tt>1</tt> according to whether the value of
//     * <i>expression</i> is negative, zero or positive.
//     *
//     * @param o the object to be compared.
//     * @return a negative integer, zero, or a positive integer as this object
//     * is less than, equal to, or greater than the specified object.
//     * @throws NullPointerException if the specified object is null
//     * @throws ClassCastException   if the specified object's type prevents it
//     *                              from being compared to this object.
//     */
//    @Override
//    public int compareTo(VirtualData o) {
//        return 0;
//    }
//
//    @Override
//    public void write(DataOutput dataOutput) throws IOException {
//        dataOutput.writeInt(key);
//        dataOutput.writeUTF(dataTime);
//        dataOutput.writeUTF(open);
//        dataOutput.writeUTF(high);
//        dataOutput.writeUTF(low);
//        dataOutput.writeUTF(close);
//        dataOutput.writeUTF(volume);
//    }
//
//    @Override
//    public void readFields(DataInput dataInput) throws IOException {
//        key=dataInput.readInt();
//        dataTime=dataInput.readUTF();
//        open=dataInput.readUTF();
//        high=dataInput.readUTF();
//        low=dataInput.readUTF();
//        close=dataInput.readUTF();
//        volume=dataInput.readUTF();
//
//    }
//
//    public VirtualData() {
//    }
//
//    public VirtualData(Integer key, String dataTime, String open, String high, String low, String close, String volume) {
//        this.key = key;
//        this.dataTime = dataTime;
//        this.open = open;
//        this.high = high;
//        this.low = low;
//        this.close = close;
//        this.volume = volume;
//    }
//
//}
