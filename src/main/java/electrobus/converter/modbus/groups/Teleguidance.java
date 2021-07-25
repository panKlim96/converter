package electrobus.converter.modbus.groups;

import electrobus.converter.modbus.ModbusFunctions;

import java.util.Arrays;
import java.util.List;

import static electrobus.converter.modbus.ModbusFunctions.*;

public enum Teleguidance {
    STATION_OPERATION_MODE_MANAGEMENT("1.1","Управление режимом работы станции", "включить/отключить",
            "Управление функцией заряда станции", Arrays.asList(24600), F3, 2),
    LIMIT_STATION_POWER("1.2","Ограничить мощность станции", "значение",
            "Установить ограничение по выходной мощности", Arrays.asList(24601), F3, 2),
    LIMIT_OUTPUT_STATION_CURRENT("1.3","Ограничить выходной ток станции", "значение",
            "Установить ограничение по выходному току", Arrays.asList(24602), F3, 2);

    public final String signalNumber;
    private final String signalName;
    private final String signalFormat;
    private final String interpretation;
    private final List<Integer> registerAddress;
    private final ModbusFunctions function;
    private final int bytesSize;

    private int registerValue;

    Teleguidance(String signalNumber, String signalName, String signalFormat, String interpretation, List<Integer> registerAddress, ModbusFunctions function, int bytesSize) {
        this.signalNumber = signalNumber;
        this.signalName = signalName;
        this.signalFormat = signalFormat;
        this.interpretation = interpretation;
        this.registerAddress = registerAddress;
        this.function = function;
        this.bytesSize = bytesSize;
    }
}
