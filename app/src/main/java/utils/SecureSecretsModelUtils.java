package utils;

import com.praxisgs.securesecrets.base.BaseEntity;

import java.util.ArrayList;
import java.util.List;

import model.RecordsEntity;
import model.SecureSecretsModel;

/**
 * Created on 04/02/2016.
 */
public class SecureSecretsModelUtils {

    public static List<BaseEntity> getCategories() {
        return getCategories(SecureSecretsModel.getInstance().getRecordsEntity());
    }

    private static List<BaseEntity> getCategories(RecordsEntity recordsEntity) {
        List<BaseEntity> categories = new ArrayList();
        if(recordsEntity !=null && recordsEntity.getRecords() !=null){
            List<RecordsEntity.Record> recordList = recordsEntity.getRecords();
            for (RecordsEntity.Record record : recordList) {
                RecordsEntity.Category category = record.getCategory();
                if (!categories.contains(category))
                    categories.add(category);
            }
        }

        return categories;
    }
}
