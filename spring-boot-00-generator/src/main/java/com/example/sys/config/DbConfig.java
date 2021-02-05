package com.example.sys.config;

import com.example.common.utils.RRException;
import com.example.mapper.GeneratorDao;
import com.example.mapper.MySQLGeneratorDao;
import com.example.mapper.OracleGeneratorDao;
import com.example.mapper.PostgreSQLGeneratorDao;
import com.example.mapper.SQLServerGeneratorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * 数据库配置
 *
 * @author Mark sunlightcs@gmail.com
 */
@Configuration
public class DbConfig {

    @Autowired
    private DbProperties dbProperties;

    @Autowired
    private MySQLGeneratorDao mySQLGeneratorDao;

    @Autowired
    private OracleGeneratorDao oracleGeneratorDao;

    @Autowired
    private SQLServerGeneratorDao sqlServerGeneratorDao;

    @Autowired
    private PostgreSQLGeneratorDao postgreSQLGeneratorDao;

    @Bean
    @Primary
    public GeneratorDao getGeneratorDao(){
        String databaseType = dbProperties.getDatabaseType();
        if("mysql".equalsIgnoreCase(databaseType)){
            return mySQLGeneratorDao;
        }else if("oracle".equalsIgnoreCase(databaseType)){
            return oracleGeneratorDao;
        }else if("sqlserver".equalsIgnoreCase(databaseType)){
            return sqlServerGeneratorDao;
        }else if("postgresql".equalsIgnoreCase(databaseType)){
            return postgreSQLGeneratorDao;
        }else {
            throw new RRException("不支持当前数据库：" + databaseType);
        }
    }
}
