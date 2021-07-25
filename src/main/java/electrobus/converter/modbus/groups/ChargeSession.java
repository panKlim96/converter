package electrobus.converter.modbus.groups;

import electrobus.converter.modbus.ModbusFunctions;

import static electrobus.converter.modbus.ModbusFunctions.F4;

public enum ChargeSession {
    CHARGE_SESSION("3.1","зарядная сессия", "значение",
            "ID сессии", "8270", F4, 2),
    SESSION_START_TIME("3.2","зарядная сессия", "значение",
            "Unix time", "8271 8272", F4, 4),
    ROLLING_STOCK_GARAGE_NUMBER("3.3","Гаражный номер подвижного состава (опционально)",
            "значение", "Идентификатор", "8273 8274", F4, 4),
    AVERAGE_CHARGE_I("3.4","Средний ток заряда", "значение",
            "Среднее значение за сессию", "8275", F4, 2),
    AVERAGE_CHARGE_U("3.6","Среднее значение мощности заряда", "значение",
            "Среднее значение за сессию", "8277", F4, 2),
    AVERAGE_CHARGE_POWER("3.6","Среднее значение мощности заряда", "значение",
            "Среднее значение за сессию", "8277", F4, 2),
    TOTAL_SESSION_POWER("3.7","Суммарная мощность сессии", "значение",
            "Нарастающий итог на текущий период", "8278", F4, 2),
    SESSION_END_TIME("3.8","Unix time", "значение",
            "Нарастающий итог на текущий период", "8279 8280", F4, 4),
    ENDING_SESSION_REASON_CODE("3.9","Код причины завершения сессии", "значение",
            "Доп. Информация", "8281", F4, 2),
    ID_ROLLING_STOCK("3.10","ID поджвижного состава", "значение",
            "S/N подвижного состава", "8288 8289 8290 8291", F4, 8),
    BATERRY_CHARGE_PERCENTAGE_START_SESSION("3.11","Процент заряда АКБ на начало зарядной сессии", "значение",
            "Уровень заряда АКБ подвижного состава до зарядки", "8292", F4, 2),
    BATERRY_CHARGE_PERCENTAGE_END_SESSION("3.12","Процент заряда АКБ нарастающим итогом", "значение",
            "Уровень заряда АКБ подвижного состава в процессе заряда", "8293", F4, 2);

    public final String signalNumber;
    private final String signalName;
    private final String signalFormat;
    private final String interpretation;
    private final String registerAddress;
    private final ModbusFunctions function;
    private final int bytesSize;

    private int registerValue;

    ChargeSession(String signalNumber, String signalName, String signalFormat, String interpretation, String registerAddress, ModbusFunctions function, int bytesSize) {
        this.signalNumber = signalNumber;
        this.signalName = signalName;
        this.signalFormat = signalFormat;
        this.interpretation = interpretation;
        this.registerAddress = registerAddress;
        this.function = function;
        this.bytesSize = bytesSize;
    }
}
