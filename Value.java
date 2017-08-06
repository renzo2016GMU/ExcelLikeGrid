import java.util.Scanner;

public class Value {
    private double dVal;
    private String sVal;
    private String tag; // indicates which one of these two attributes

    public Value() { //
	this.dVal = 0;
	this.sVal = "null";
	this.tag = "";
    }

    public Value(String x) {
	dVal = 0;
	sVal = null;
	tag = "String";
	input(x);// my input method works as set tag
    }

    /* 8 th sentence of the class description says to make the ctr like this */
    public void input(String string) {
	if (string.startsWith("\"")){
	    setsVal(string);
	    setTag("String"); // 's' will be the tag for Values that are strings
	    return;
	}
	if (string.matches("\\s*[0-9]{1,9}(\\.[0-9]*)?")){ // at least one number
	    this.setdVal(Double.parseDouble(string));
	    setTag("Number"); // 'n' will be the tag for Values that are strings
	    return;
	}
    }

    public String toString() {
	if (this.getTag().matches("Number"))
	    return String.format("%10.4f", getdVal());

	if (getTag().matches("String"))
	    return String.format("%10s", getsVal());
	return "";
    }

    public Value sum(Value valIn){
	Value answer = new Value();
	double answer1;

	if (this.getTag().matches("Number") && valIn.getTag().matches("Number")) {

	    answer1 = this.getdVal() + valIn.getdVal();
	    answer.input(answer1 + "");
	    return answer;
	}
	System.out.println("Invalid values");
	return answer;
    }

    public Value subtract(Value valIn){
	Value answer = new Value();
	double answer1;

	if (this.getTag().matches("Number") && valIn.getTag().matches("Number")) {
	    answer1 = this.getdVal() - valIn.getdVal();
	    answer.input(answer1 + "");
	    return answer;
	}
	System.out.println("Invalid values");
	return answer;
    }

    public Value multiply(Value valIn) {
	Value answer = new Value();
	double answer1;
	if (this.getTag().matches("Number") && valIn.getTag().matches("Number")) {

	    answer1 = this.getdVal() * valIn.getdVal();
	    answer.input(answer1 + "");
	    return answer;
	}
	System.out.println("Invalid values");
	return answer;
    }

    public Value slash(Value valIn) {
	Value answer = new Value();
	double answer1;

	if (this.getTag().matches("Number") && valIn.getTag().matches("Number")) {

	    answer1 = this.getdVal() / valIn.getdVal();
	    answer.input(answer1 + "");
	    return answer;
	}
	System.out.println("Invalid values");
	return answer;
    }

    public void resetValue() {
	this.dVal = 0;
	this.sVal = "";
	this.tag = "";
    }

    public static void main(String[] args) {

	Value four = new Value("1.1");
	Value diez = new Value(" 20.0000");
	Scanner sc = new Scanner(System.in);
	Value x = new Value("4.0");
	Value result = diez.slash(four);
	System.out.println("Your result is" + result.toString());
	System.out.println(x.toString());
	System.out.println("Enter a value (for Strings ad a double quote mark at the begining)");
	four.input(sc.nextLine());
	System.out.println(four.toString());
    }
    /* Getters and Setters */

    public void setTag(String tag) {

	this.tag = tag;
    }

    public double getdVal() {
	return dVal;
    }

    public void setdVal(double dVal) {
	this.dVal = dVal;
    }

    public String getsVal() {
	return sVal;
    }

    public void setsVal(String sVal) {
	this.sVal = sVal;
    }

    public String getTag() {
	return tag;
    }
}