package first.example;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import static org.apache.spark.sql.functions.*;

public class SparkExample {

    public static void main(String[] args) {

        SparkSession spark = SparkSession.builder().master("local[*]").appName("spark-job").getOrCreate();
        spark.sql("set spark.sql.orc.impl=native");

        Dataset<Compte> comptes = spark.read().option("header", "true").option("sep", ";")
                                       .csv("mohamed-example/compte.csv").as(Encoders.bean(Compte.class));
        Dataset<Row> res1 = comptes.select("id_custumer", "type_compte", "montant_transaction")
                                   .groupBy("id_custumer", "type_compte")
                                   .agg(sum("monta nt_transaction").alias("total_transaction"));

        Dataset<Row> res2 = comptes
                .select(col("id_custumer"),
                        year(col("date_tansaction")),
                        col("montant_transaction")).groupBy("id_custumer", "year(date_tansaction)")
                .agg(sum("montant_transaction"));

        res1.show();
        res2.show();
    }

}
