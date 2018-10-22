package com.gsrk.dataflow.processor;


import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.integration.annotation.Transformer;


/**
 * Hello world!
 *
 */
@EnableBinding(Processor.class)
@SpringBootApplication
public class ProcessorApplication 
{
	private static Logger logger = LoggerFactory.getLogger(ProcessorApplication.class);

	@Transformer(inputChannel = Processor.INPUT, outputChannel = Processor.OUTPUT)
    public Object transform(Long date) {

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        logger.info("format date:{}",dateFormat.toString());
        return dateFormat.format(date);
    }
	
    public static void main( String[] args )
    {
       SpringApplication.run(ProcessorApplication.class, args);
    }
}
