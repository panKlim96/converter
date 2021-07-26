package electrobus.converter;

import net.wimpi.modbus.Modbus;
import net.wimpi.modbus.ModbusCoupler;
import net.wimpi.modbus.net.ModbusTCPListener;
import net.wimpi.modbus.procimg.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.InetAddress;

@SpringBootApplication
public class ConverterApplication {
    //static boolean isListenerCreated = false;
    public static void main(String[] args) {
        try {
            System.setProperty("spring.devtools.restart.enabled", "false");
            SimpleProcessImage spi = null;
            int port = Modbus.DEFAULT_PORT;

            // Prepare a process image
            spi = new SimpleProcessImage();

            Register register1 = new SimpleInputRegister(0);

            // Регистры(input) для сигналов 1 - 4.1
            for (int i = 0; i < 25; i++) {
                spi.addInputRegister(register1);
            }

            // Флаги для 4.2 - 4.11
            for (int i = 0; i < 10; i++) {
                spi.addDigitalIn(new SimpleDigitalIn(false));
            }

            // Регистры(input) для сигналов 5.1 - 5.4
            for (int i = 0; i < 5; i++) {
                spi.addInputRegister(new SimpleInputRegister(0));
            }

            // Регистры(holding) для сигналов 1.1 - 1.3
            for (int i = 0; i < 3; i++) {
                spi.addRegister(new SimpleRegister(0));
            }

//			Long l = Long.parseLong("978");
//			ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
//			buffer.putLong(l);

            ModbusCoupler.getReference().setProcessImage(spi);
            ModbusCoupler.getReference().setMaster(false);
            ModbusCoupler.getReference().setUnitID(15);

            final InetAddress address = InetAddress.getByName("127.0.0.1");//LAPTOP-M4029LFV
            // Create a listener with 1 threads in pool
            ModbusTCPListener listener = new ModbusTCPListener(1);
            listener.setAddress(address);
            listener.setPort(port);
            listener.start();

            SpringApplication.run(ConverterApplication.class, args);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}