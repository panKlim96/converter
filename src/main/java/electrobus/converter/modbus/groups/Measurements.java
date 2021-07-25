package electrobus.converter.modbus.groups;

import electrobus.converter.modbus.ModbusFunctions;

import java.util.Arrays;
import java.util.List;

import static electrobus.converter.modbus.ModbusFunctions.*;

public enum Measurements {
    INPUT_VOLTAGE_LEVEL("5.1","Уровень входного напряжения", "значение",
            "Значение питающего напряжения 600В", Arrays.asList(8320), F4, 2),
    TEMPERATURE_INSIDE_THE_CP("5.2","Температура внутри ЗС", "значение",
            "Значение температуры внутри ЗС (с коэффициеннтом 10)", Arrays.asList(8321), F4, 2),
    TRANSMITTED_ELECTRICITY_METER_GENERAL("5.3","Счетчик переданной электроэнергии, общий", "значение",
            "Общее значение заряженной мощности", Arrays.asList(8322, 8323), F4, 4),
    TRANSMITTED_ELECTRICITY_METER_DAILY("5.4", "Счетчик переданной электроэнергии, суточный", "значение",
            "Значение заряженной мощности за сутки", Arrays.asList(8324), F4, 2);

    public final String signalNumber;
    private final String signalName;
    private final String signalFormat;
    private final String interpretation;
    private final List<Integer> registerAddress;
    private final ModbusFunctions function;
    private final int bytesSize;

    private int registerValue;

    Measurements(String signalNumber, String signalName, String signalFormat, String interpretation, List<Integer> registerAddress, ModbusFunctions function, int bytesSize) {
        this.signalNumber = signalNumber;
        this.signalName = signalName;
        this.signalFormat = signalFormat;
        this.interpretation = interpretation;
        this.registerAddress = registerAddress;
        this.function = function;
        this.bytesSize = bytesSize;
    }
}
