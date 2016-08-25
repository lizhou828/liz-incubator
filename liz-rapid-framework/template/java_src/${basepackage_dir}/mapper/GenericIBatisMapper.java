package ${basepackage}.mapper;

import java.io.Serializable;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GenericIBatisMapper<T, PK extends Serializable> {
    T getByPK(PK var1);

    List<T> list();

    List<T> listByProperty(T var1);

    int deleteByPK(PK var1);

    void deleteByPKeys(@Param("primaryKeys") List<PK> var1);

    int deleteByProperty(T var1);

    void save(T var1);

    int update(T var1);

    int findByCount(T var1);
}
