package first.example;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class SparkExample {

	public static void main(String[] args) {
		
		SparkSession spark = SparkSession.builder().master("local[*]").appName("spark-job").getOrCreate();
		spark.sql("set spark.sql.orc.impl=native");
		
		Dataset<Row> comptes = spark.read().option("header", "false").csv("mohamed-example/compte.csv");


	}

}
