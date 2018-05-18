package first.example;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import static org.apache.spark.sql.functions.*;

public class SparkExample {

    public static void main(String[] args) {

        String idCostumer = "id_costumer";
        String montantTransaction = "montant_transaction";
        SparkSession spark = SparkSession.builder().master("local[*]").appName("spark-job").getOrCreate();
        spark.sql("set spark.sql.orc.impl=native");

        Dataset<Compte> comptes = spark.read().option("header", "true").option("sep", ";")
                                       .csv("mohamed-example/compte.csv").as(Encoders.bean(Compte.class));

        Dataset<Customer> customers = spark.read().option("header", "true").option("sep", ";")
                                       .csv("mohamed-example/customer.csv").as(Encoders.bean(Customer.class));
        Dataset<Row> res1 = customers.join(comptes, idCostumer);


        Dataset<Row> res2 = res1.select(idCostumer, "type_compte", montantTransaction, "first_name")
                                   .groupBy(idCostumer, "type_compte","first_name")
                                   .agg(sum(montantTransaction).alias("total_transaction"));

        Dataset<Row> res3 = comptes
                .select(col(idCostumer),
                        year(col("date_transaction")),
                        col(montantTransaction)).groupBy(idCostumer, "year(date_transaction)")
                .agg(sum(montantTransaction));

        res1.show();
        res2.show();
        res3.show();
    }

}
