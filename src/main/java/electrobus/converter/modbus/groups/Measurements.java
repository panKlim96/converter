package electrobus.converter.modbus.groups;

import electrobus.converter.modbus.ModbusFunctions;

import static electrobus.converter.modbus.ModbusFunctions.*;

public enum Measurements {
    INPUT_VOLTAGE_LEVEL("5.1","Уровень входного напряжения", "значение",
            "Значение питающего напряжения 600В", "8320", F4, 2),
    TEMPERATURE_INSIDE_THE_CP("5.2","Температура внутри ЗС", "значение",
            "Значение температуры внутри ЗС (с коэффициеннтом 10)", "8321", F4, 2),
    TRANSMITTED_ELECTRICITY_METER_GENERAL("5.3","Счетчик переданной электроэнергии, общий", "значение",
            "Общее значение заряженной мощности", "8322 8323", F4, 4),
    TRANSMITTED_ELECTRICITY_METER_DAILY("5.4", "Счетчик переданной электроэнергии, суточный", "значение",
            "Значение заряженной мощности за сутки", "8324", F4, 2);

    public final String signalNumber;
    private final String signalName;
    private final String signalFormat;
    private final String interpretation;
    private final String registerAddress;
    private final ModbusFunctions function;
    private final int bytesSize;

    private int registerValue;

    Measurements(String signalNumber, String signalName, String signalFormat, String interpretation, String registerAddress, ModbusFunctions function, int bytesSize) {
        this.signalNumber = signalNumber;
        this.signalName = signalName;
        this.signalFormat = signalFormat;
        this.interpretation = interpretation;
        this.registerAddress = registerAddress;
        this.function = function;
        this.bytesSize = bytesSize;
    }
}
