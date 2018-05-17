package first.example;

import org.apache.spark.sql.*;

public class SparkExample {

    public static void main(String[] args) {

        SparkSession spark = SparkSession.builder().master("local[*]").appName("spark-job").getOrCreate();
        spark.sql("set spark.sql.orc.impl=native");

        Dataset<Row> comptes = spark.read().option("header", "true").option("sep",";").csv("mohamed-example/compte.csv");
        Encoder<Compte> compteEncoder = Encoders.bean(Compte.class);
        Dataset<Compte> compteDF = comptes.as(compteEncoder);
        compteDF.show();


    }

}
