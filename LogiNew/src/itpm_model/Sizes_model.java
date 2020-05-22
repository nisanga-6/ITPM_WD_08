package itpm_model;

public class Sizes_model {

	int Keyword,Identifier,Operator,Numerical,StringCount,lineNumber;
	String line;
	
	public int getKeyword() {
		return Keyword;
	}
	public void setKeyword(int keyword) {
		Keyword = keyword;
	}
	public int getIdentifier() {
		return Identifier;
	}
	public void setIdentifier(int identifier) {
		Identifier = identifier;
	}
	public int getOperator() {
		return Operator;
	}
	public void setOperator(int operator) {
		Operator = operator;
	}
	public int getNumerical() {
		return Numerical;
	}
	public void setNumerical(int numerical) {
		Numerical = numerical;
	}
	public int getStringCount() {
		return StringCount;
	}
	public void setStringCount(int stringCount) {
		StringCount = stringCount;
	}
	public int getLineNumber() {
		return lineNumber;
	}
	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}
	public String getLine() {
		return line;
	}
	public void setLine(String line) {
		this.line = line;
	}
	
}
