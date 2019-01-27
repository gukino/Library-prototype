package factory;

import Service.component3.DocStrategy;
import Service.component3.EpubStrategy;
import Service.component3.PdfStrategy;
import Service.component3.ReadStrategy;

/**
 * @ClassNameBorrowFactory
 * @Describtion 简单工厂对不同格式的文档的阅读生成不同策略
 * @Author
 * @Version 1.0
 **/
public class StrategyFactory {
    public static ReadStrategy createStrategy(String bookType) {
        ReadStrategy strategy = null;
        switch (bookType) {
            case "pdf":
                strategy = new PdfStrategy();
                break;
            case "doc":
                strategy = new DocStrategy();
                break;
            case "epub":
                strategy = new EpubStrategy();
                break;
        }
        return strategy;
    }
}
