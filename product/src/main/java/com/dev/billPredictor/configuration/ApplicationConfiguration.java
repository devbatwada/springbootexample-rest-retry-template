package com.dev.billPredictor.configuration;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.retry.RetryPolicy;
import org.springframework.retry.policy.CompositeRetryPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.policy.TimeoutRetryPolicy;
import org.springframework.retry.support.RetryTemplate;
import org.yaml.snakeyaml.util.ArrayUtils;

/**
 * Created by dbatwada on 5/20/18.
 */
@Configuration
public class ApplicationConfiguration
{
    @Bean
    public RetryTemplate retryTemplate(@Autowired RetryPolicy retryPolicy)
    {
        RetryTemplate retryTemplate = new RetryTemplate();
        retryTemplate.setRetryPolicy(retryPolicy);
        return retryTemplate;
    }


    @Bean
    public RetryPolicy retryPolicy(@Value("${com.dev.billPredictor.remoteHistoryServie/retryAttemptCount}") int
                                           retryAttemptCount, @Value("${com.dev.billPredictor" +
            ".remoteHistoryServie/timeOutInMillis}") int timeout)
    {
        SimpleRetryPolicy simpleRetryPolicy = new SimpleRetryPolicy();
        simpleRetryPolicy.setMaxAttempts(retryAttemptCount);

        TimeoutRetryPolicy timeoutRetryPolicy = new TimeoutRetryPolicy();
        timeoutRetryPolicy.setTimeout(timeout);

        return new CompositeRetryPolicy()
        {{
            setPolicies(new RetryPolicy[]{simpleRetryPolicy, timeoutRetryPolicy});
        }};
    }

    @Bean
    public static PropertyPlaceholderConfigurer propertyPlaceholderConfigurer(
            @Value("classpath:appconfig.properties") Resource[] properties){
        PropertyPlaceholderConfigurer configurer =
                new PropertyPlaceholderConfigurer();
        configurer.setIgnoreResourceNotFound(false);
        configurer.setLocations(properties);
        configurer.setLocalOverride(true);
        configurer.setNullValue("{null}");
        return configurer;
    }



}
