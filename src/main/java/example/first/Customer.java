package example.first;

import org.apache.spark.sql.SparkSession;

public class Customer {
    SparkSession session = SparkSession.builder().master("local[*]").appName("mohamed-example").getOrCreate();
}
