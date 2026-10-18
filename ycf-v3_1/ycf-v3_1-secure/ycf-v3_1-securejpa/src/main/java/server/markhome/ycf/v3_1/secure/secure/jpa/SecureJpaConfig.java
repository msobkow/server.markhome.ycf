// Description: Java 25 JPA implementation of a Secure connection configuration

/*
 *	server.markhome.ycf.Secure
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Yorkton Code Fractal 3.1 Secure - Security Services
 *	
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow mark.sobkow@gmail.com
 *	
 *	These files are part of Yorkton Code Fractal Secure.
 *	
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *	
 *	http://www.apache.org/licenses/LICENSE-2.0
 *	
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 *	
 */

package server.markhome.ycf.v3_1.secure.secure.jpa;
//package server.markhome.ycf.v3_1.secure.secure.jpa;

import java.io.Serializable;
import java.math.*;
import java.time.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import javax.sql.DataSource;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.apache.commons.codec.binaryYCFCore64;
import org.apache.commons.text.StringEscapeUtils;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import server.markhome.ycf.*;
import server.markhome.ycf.dbutil.*;
import server.markhome.ycf.YCFXmlUtil;
import server.markhome.ycf.v3_1.secure.secure.*;

@Configuration
@EntityScan(basePackages = "server.markhome.ycf.v3_1.secure.secure.jpa")
@EnableTransactionManagement
@EnableJpaRepositories(
    basePackages = "server.markhome.ycf.v3_1.secure.secure.jpa",
    entityManagerFactoryRef = "secure31EntityManagerFactory",
    transactionManagerRef = "secure31TransactionManager"
)
public class SecureJpaConfig
{
	@Autowired
	@Qualifier("appMergedProperties")
	private Properties appMergedProperties;

    public final static String persistenceUnitName = "secure31PU";

    private static final AtomicReference<DataSource> refSecure31DataSource = new AtomicReference<>(null);
    private static final AtomicReference<Properties> secure31JpaProperties = new AtomicReference<>(null);
    private static final AtomicReference<LocalContainerEntityManagerFactoryBean> refSecure31EntityManagerFactoryBean = new AtomicReference<>(null);

    @Bean(name = "secure31DataSource")
    @Primary
    public DataSource secure31DataSource() {
        if (refSecure31DataSource.get() == null) {
            Properties props = appMergedProperties;

            HikariConfig config = new HikariConfig();
            config.setDriverClassName(props.getProperty("secure31.jakarta.persistence.jdbc.driver", props.getProperty("jakarta.persistence.jdbc.driver", "org.postgresql.Driver")));
            config.setJdbcUrl(props.getProperty("secure31.jakarta.persistence.jdbc.url", props.getProperty("jakarta.persistence.jdbc.url", "jdbc:postgresql://localhost:5432/yourdb")));
            config.setUsername(props.getProperty("secure31.jakarta.persistence.jdbc.user", props.getProperty("jakarta.persistence.jdbc.user", "postgres")));
            config.setPassword(props.getProperty("secure31.jakarta.persistence.jdbc.password", props.getProperty("jakarta.persistence.jdbc.password", "pgpassword")));

            config.setMaximumPoolSize(Integer.parseInt(props.getProperty("secure31.hikari.maximumPoolSize", props.getProperty("hikari.maximumPoolSize", "10"))));
            config.setMinimumIdle(Integer.parseInt(props.getProperty("secure31.hikari.minimumIdle", props.getProperty("hikari.minimumIdle", "5"))));
            config.setPoolName(props.getProperty("secure31.hikari.poolName", props.getProperty("hikari.poolName", "Secure31HikariCP")));
            config.setAutoCommit(Boolean.getBoolean(props.getProperty("secure31.hikari.auto-commit", props.getProperty("hikari.auto-commit", "true"))));

            DataSource ds = new HikariDataSource(config);

            refSecure31DataSource.compareAndSet(null, ds);
        }
        return refSecure31DataSource.get();
    }

    @Bean(name = "secure31JpaProperties")
    @Primary
    public Properties secure31JpaProperties() {
        if (secure31JpaProperties.get() == null) {
            // Build the effective properties for secure31
            // The persistence unit name must match the one in your persistence.xml, or you can use a dynamic unit
            Properties merged = appMergedProperties;
            String jakartaPersistenceJdbcDriver = merged.getProperty("secure31.jakarta.persistence.jdbc.driver", merged.getProperty("jakarta.persistence.jdbc.driver", null));
            String jakartaPersistenceJdbcUrl = merged.getProperty("secure31.jakarta.persistence.jdbc.url", merged.getProperty("jakarta.persistence.jdbc.url", "jdbc:postgresql://localhost:5432/dbtestdb"));
            String jakartaPersistenceJdbcUser = merged.getProperty("secure31.jakarta.persistence.jdbc.user", merged.getProperty("jakarta.persistence.jdbc.user", "postgres"));
            String jakartaPersistenceJdbcPassword = merged.getProperty("secure31.jakarta.persistence.jdbc.password", merged.getProperty("jakarta.persistence.jdbc.password", "pgpassword"));
            String jakartaPersistenceSchemaGenerationDatabaseAction = merged.getProperty("secure31.jakarta.persistence.schema-generation.database.action", merged.getProperty("jakarta.persistence.schema-generation.database.action", null));
            String jakartaPersistenceSchemaGenerationScriptsAction = merged.getProperty("secure31.jakarta.persistence.schema-generation.scripts.action", merged.getProperty("jakarta.persistence.schema-generation.scripts.action", null));
            String jakartaPersistenceSchemaGenerationCreateSource = merged.getProperty("secure31.jakarta.persistence.schema-generation.create-source", merged.getProperty("jakarta.persistence.schema-generation.create-source", "metadata"));
            String jakartaPersistenceSchemaGenerationDropSource = merged.getProperty("secure31.jakarta.persistence.schema-generation.drop-source", merged.getProperty("jakarta.persistence.schema-generation.drop-source", "metadata"));
            String jakartaPersistenceCreateDatabaseSchemas = merged.getProperty("secure31.jakarta.persistence.create-database-schemas", merged.getProperty("jakarta.persistence.create-database-schemas", "true"));
            // String jakartaNonJtaDataSource = merged.getProperty("secure31.jakarta.persistence.nonJtaDataSource", merged.getProperty("jakarta.persistence.nonJtaDataSource", null));
            // String jakartaJtaDataSource = merged.getProperty("secure31.jakarta.persistence.jtaDataSource", merged.getProperty("jakarta.persistence.jtaDataSource", null));
            String hibernateDialect = merged.getProperty("secure31.hibernate.dialect", merged.getProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect"));
            String hibernateHbm2ddlAuto = merged.getProperty("secure31.hibernate.hbm2ddl.auto", merged.getProperty("hibernate.hbm2ddl.auto", "update"));
            String hibernateShowSql = merged.getProperty("secure31.hibernate.show_sql", merged.getProperty("hibernate.show_sql", "false"));
            String hibernateFormatSql = merged.getProperty("secure31.hibernate.format_sql", merged.getProperty("hibernate.format_sql", "false"));
            String hibernateConnectionPoolSize = merged.getProperty("secure31.hibernate.connection_pool_size", merged.getProperty("hibernate.connection_pool_size", "10"));
            String hibernateConnectionDatasource = merged.getProperty("secure31.hibernate.connection_datasource", merged.getProperty("hibernate.connection_datasource", null));
            String hibernateCacheRegionFactoryClass = merged.getProperty("secure31.hibernate.cache.region.factory_class", merged.getProperty("hibernate.cache.region.factory_class", null));
            String hibernateDefaultSchema = merged.getProperty("secure31.hibernate.default_schema", "secure31");
            // String hibernateTransactionJTAPlatform = merged.getProperty("secure31.hibernate.transaction.jta.platform", merged.getProperty("hibernate.transaction.jta.platform", "org.hibernate.engine.transaction.jta.platform.internal.SpringJtaPlatform"));


            Properties applicable = new Properties();
            if (persistenceUnitName != null && !persistenceUnitName.isEmpty()) {
                applicable.setProperty("jakarta.persistence.unitName", persistenceUnitName);
            }
            if (jakartaPersistenceJdbcDriver != null && !jakartaPersistenceJdbcDriver.isEmpty()) {
                applicable.setProperty("jakarta.persistence.jdbc.driver", jakartaPersistenceJdbcDriver);
            }
            if (jakartaPersistenceJdbcUrl != null && !jakartaPersistenceJdbcUrl.isEmpty()) {
                applicable.setProperty("jakarta.persistence.jdbc.url", jakartaPersistenceJdbcUrl);
            }
            if (jakartaPersistenceJdbcUser != null && !jakartaPersistenceJdbcUser.isEmpty()) {
                applicable.setProperty("jakarta.persistence.jdbc.user", jakartaPersistenceJdbcUser);
            }
            if (jakartaPersistenceJdbcPassword != null && !jakartaPersistenceJdbcPassword.isEmpty()) {
                applicable.setProperty("jakarta.persistence.jdbc.password", jakartaPersistenceJdbcPassword);
            }
            if (jakartaPersistenceSchemaGenerationDatabaseAction != null && !jakartaPersistenceSchemaGenerationDatabaseAction.isEmpty()) {
                applicable.setProperty("jakarta.persistence.schema-generation.database.action", jakartaPersistenceSchemaGenerationDatabaseAction);
            }
            if (jakartaPersistenceSchemaGenerationScriptsAction != null && !jakartaPersistenceSchemaGenerationScriptsAction.isEmpty()) {
                applicable.setProperty("jakarta.persistence.schema-generation.scripts.action", jakartaPersistenceSchemaGenerationScriptsAction);
            }
            if (jakartaPersistenceSchemaGenerationCreateSource != null && !jakartaPersistenceSchemaGenerationCreateSource.isEmpty()) {
                applicable.setProperty("jakarta.persistence.schema-generation.create-source", jakartaPersistenceSchemaGenerationCreateSource);
            }
            if (jakartaPersistenceSchemaGenerationDropSource != null && !jakartaPersistenceSchemaGenerationDropSource.isEmpty()) {
                applicable.setProperty("jakarta.persistence.schema-generation.drop-source", jakartaPersistenceSchemaGenerationDropSource);
            }
            if (jakartaPersistenceCreateDatabaseSchemas != null && !jakartaPersistenceCreateDatabaseSchemas.isEmpty()) {
                applicable.setProperty("jakarta.persistence.create-database-schemas", jakartaPersistenceCreateDatabaseSchemas);
            }

            if (hibernateDialect != null && !hibernateDialect.isEmpty()) {
                applicable.setProperty("hibernate.dialect", hibernateDialect);
            }
            if (hibernateHbm2ddlAuto != null && !hibernateHbm2ddlAuto.isEmpty()) {
                applicable.setProperty("hibernate.hbm2ddl.auto", hibernateHbm2ddlAuto);
            }
            if (hibernateShowSql != null && !hibernateShowSql.isEmpty()) {
                applicable.setProperty("hibernate.show_sql", hibernateShowSql);
            }
            if (hibernateFormatSql != null && !hibernateFormatSql.isEmpty()) {
                applicable.setProperty("hibernate.format_sql", hibernateFormatSql);
            }
            if (hibernateConnectionPoolSize != null && !hibernateConnectionPoolSize.isEmpty()) {
                applicable.setProperty("hibernate.connection_pool_size", hibernateConnectionPoolSize);
            }
            if (hibernateConnectionDatasource != null && !hibernateConnectionDatasource.isEmpty()) {
                applicable.setProperty("hibernate.connection.datasource", hibernateConnectionDatasource);
            }
            if (hibernateCacheRegionFactoryClass != null && !hibernateCacheRegionFactoryClass.isEmpty()) {
                applicable.setProperty("hibernate.cache.region.factory_class", hibernateCacheRegionFactoryClass);
            }
            if (hibernateDefaultSchema != null && !hibernateDefaultSchema.isEmpty()) {
                applicable.setProperty("hibernate.default_schema", hibernateDefaultSchema);
            }

            // // A JTA implementation is required as a standalone application, but you can use implementations for specific J2EE servers, such as WebLogic, too
            // if (hibernateTransactionJTAPlatform != null && !hibernateTransactionJTAPlatform.isEmpty()) {
            //     applicable.setProperty("hibernate.transaction.jta.platform", hibernateTransactionJTAPlatform);
            // }
            // // If you want to use a JTA DataSource, you can set it here
            // if (jakartaJtaDataSource != null && !jakartaJtaDataSource.isEmpty()) {
            //     applicable.setProperty("jakarta.persistence.jtaDataSource", jakartaJtaDataSource);
            // }
            // // If you want to use a non-JTA DataSource, you can set it here
            // if (jakartaNonJtaDataSource != null && !jakartaNonJtaDataSource.isEmpty()) {
            //     applicable.setProperty("jakarta.persistence.nonJtaDataSource", jakartaNonJtaDataSource);
            // }
 
            secure31JpaProperties.compareAndSet(null, applicable);
        }
        return secure31JpaProperties.get();
    }

    @Bean(name = "secure31EntityManagerFactory")
    @Primary
    public LocalContainerEntityManagerFactoryBean secure31EntityManagerFactory(
        @Qualifier("secure31DataSource") DataSource secure31DataSource,
        @Qualifier("secure31JpaProperties") Properties secure31JpaProperties) {
        // if (refSecure31EntityManagerFactoryBean.get() == null) {
            // Create the EntityManagerFactory using the Jakarta Persistence API
            try {
                System.err.println("Creating secure31EntityManagerFactory with properties:");
                secure31JpaProperties.forEach((key, value) -> {
                    if (value instanceof String) {
                        String s = (String)value;
                        System.err.println("  " + key + " = " + s);
                    }
                    else {
                        String classname = value.getClass().getName();
                        System.err.println("  " + key + " = instanceof(" + classname + ")");
                    }
                });

                // Configure EntityManagerFactoryBean
                LocalContainerEntityManagerFactoryBean emfBean = new LocalContainerEntityManagerFactoryBean();
                emfBean.setDataSource(secure31DataSource);
                emfBean.setPackagesToScan("server.markhome.ycf.v3_1.secure.secure.jpa");
                emfBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
                emfBean.setJpaProperties(secure31JpaProperties);
                emfBean.setPersistenceUnitName(persistenceUnitName);
                return emfBean;
                // refSecure31EntityManagerFactoryBean.compareAndSet(null, emfBean);
            } catch (Exception e) {
                System.err.println("ERROR: Persistence.createEntityManagerFactory(\"" + persistenceUnitName + "\", emfProperties) threw " + e.getClass().getName() + ": " + e.getMessage());
                e.printStackTrace(System.err);
                throw e;
            }
        // }
        // return refSecure31EntityManagerFactoryBean.get();
    }

    @Bean(name = "secure31TransactionManager")
    @Primary
    public JpaTransactionManager secure31TransactionManager(
        @Qualifier("secure31EntityManagerFactory") LocalContainerEntityManagerFactoryBean secure31EntityManagerFactory) {
            EntityManagerFactory f = secure31EntityManagerFactory.getObject();
            if (f != null) {
                return new JpaTransactionManager(f);
            }
            else {
                System.err.println("ERROR: Secure31JpaConfig.secure31TransactionManager() secure31EntityManagerFactoryBean.getObject() returned null");
				throw new YCFNullArgumentException(getClass(), "secure31TransactionManater", 0, "secure31EntityManagerFactoryBean.getObject()");
            }
    }
}
