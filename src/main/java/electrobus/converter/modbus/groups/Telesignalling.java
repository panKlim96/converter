package electrobus.converter.modbus.groups;

import electrobus.converter.modbus.ModbusFunctions;

import java.util.Arrays;
import java.util.List;

import static electrobus.converter.modbus.ModbusFunctions.*;

public enum Telesignalling {
    STATION_ID( "1", "ID станции", "значение",
            "Идентификатор станции", Arrays.asList(8200), F4, 2);

    public final String signalNumber;
    private final String signalName;
    private final String signalFormat;
    private final String interpretation;
    private final List<Integer> registerAddress;
    private final ModbusFunctions function;
    private final int bytesSize;

    private int registerValue;

    public void setRegisterValue(int registerValue) {
        this.registerValue = registerValue;
    }

    Telesignalling(String signalNumber, String signalName, String signalFormat, String interpretation, List<Integer> registerAddress, ModbusFunctions function, int bytesSize) {
        this.signalNumber = signalNumber;
        this.signalName = signalName;
        this.signalFormat = signalFormat;
        this.interpretation = interpretation;
        this.registerAddress = registerAddress;
        this.function = function;
        this.bytesSize = bytesSize;
    }
}
