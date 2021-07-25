package electrobus.converter.modbus.groups;

import electrobus.converter.modbus.ModbusFunctions;

import static electrobus.converter.modbus.ModbusFunctions.F4;

public enum ChargePointState {
    STATION_STATE("2.1","состояние станции", "значение",
            "Состояние станции/заряда/неисправности", 8250, F4, 2),
    MAX_STATION_POWER( "2.2", "Макс. мощность станции", "значение",
            "Доступная мощность", 8251, F4, 2),
    MAX_STATION_I("2.3", "Макс. ток станции", "значение",
            "Доступный зарядный ток ", 8252, F4, 2),
    MAX_STATION_U("2.4", "Макс. напряжение станции", "значение",
            "Макс. выходное напряжение станции", 8253, F4, 2),
    RES("2.5", "Резерв", "значение",
            "Резерв", 8254, F4, 2);

    public final String signalNumber;
    private final String signalName;
    private final String signalFormat;
    private final String interpretation;
    private final int registerAddress;
    private final ModbusFunctions function;
    private final int bytesSize;

    private int registerValue;

    ChargePointState(String signalNumber, String signalName, String signalFormat, String interpretation, int registerAddress, ModbusFunctions function, int bytesSize) {
        this.signalNumber = signalNumber;
        this.signalName = signalName;
        this.signalFormat = signalFormat;
        this.interpretation = interpretation;
        this.registerAddress = registerAddress;
        this.function = function;
        this.bytesSize = bytesSize;
    }
}
