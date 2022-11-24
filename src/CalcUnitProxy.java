import java.io.PrintWriter;
import java.util.GregorianCalendar;


public class CalcUnitProxy implements CalcUnit {
    private CalcUnit calcUnit;
    private PrintWriter writer;

    public void setLogWriter(PrintWriter pw) {
        this.writer = pw;
    }

    public void setCalcUnit(CalcUnit cu) {
        this.calcUnit = cu;
    }

    @Override
    public boolean fit(String operator) {
        String currTime = String.valueOf(GregorianCalendar.getInstance().getTime());
        writer.printf("[%s] 判断操作符%s是否符合当前计算单元：%s\n", currTime, this.calcUnit.toString(), String.valueOf(this.calcUnit.fit(operator)));
        return this.calcUnit.fit(operator);
    }

    @Override
    public double calc(double x, double y) {
        String currTime = String.valueOf(GregorianCalendar.getInstance().getTime());
        writer.printf("[%s] 计算 %.1f%s%.1f 的结果为: %.1f\n", currTime, x, this.calcUnit.toString(), y, this.calcUnit.calc(x, y));
        return this.calcUnit.calc(x, y);
    }
}
