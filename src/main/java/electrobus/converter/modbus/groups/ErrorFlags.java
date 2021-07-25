package electrobus.converter.modbus.groups;

import electrobus.converter.modbus.ModbusFunctions;

import static electrobus.converter.modbus.ModbusFunctions.*;

public enum ErrorFlags {
    INTЕRNAL_CP_FAULT("4.1","Внутренняя неисправность ЗС", "значение",
            "Доп. информация для пределения внутренних ошибок", "8301", F4, 2),
    NO_VOLTAGE_600("4.2","Отсутствует напряжение питания 600В", "Да/Нет",
            "", "10", F2, 0),
    VOLTAGE_600_BELOW_NORM("4.3","Напряжение питания 600В ниже нормы", "Да/Нет",
            "", "11", F2, 0),
    VOLTAGE_600_ABOVE_NORM("4.4","Напряжение питания 600В выше нормы", "Да/Нет",
            "", "12", F2, 0),
    ISOLATION_CONTROL_OF_INPUT_CIRCUITS_TRIGGERING("4.5","Срабатывание контроля изоляции входных цепей", "Да/Нет",
            "", "13", F2, 0),
    MAIN_AUTOMATIC_SWITCH_0F_POWER_DISABLED("4.6","Отключен главный автоматический выключатель питания ЗС", "Да/Нет",
            "", "14", F2, 0),
    CP_COOLING_COOLERS_OVERHEATING_OR_MALFUNCTION("4.7","Перегрев или неисправность куллеров охлаждения ЗС", "Да/Нет",
            "", "15", F2, 0),
    TECHNOLOGICAL_HATCHES_OPENING("4.8","Открытие технологических люков (дверей)", "Да/Нет",
            "", "16", F2, 0),//
    PROTECTION_OUTPUT_CIRCUITS_TRIGGERING_AGAINST_EXCESS_CURRENT("4.9","Срабатывание выходных цепей защиты от превышения тока", "Да/Нет",
            "", "17", F2, 0),//
    OUTPUT_CIRCUITS_ISOLATION_CONTROL_TRIGGERING("4.10","Срабатывание контроля изоляции выходных цепей", "Да/Нет",
            "", "18", F2, 0),
    FIRE_ALARM_TRIGGERING("4.11","Срабатывание пожарной сигнализации", "Да/Нет",
            "", "19", F2, 0);

    public final String signalNumber;
    private final String signalName;
    private final String signalFormat;
    private final String interpretation;
    private final String registerAddress;
    private final ModbusFunctions function;
    private final int bytesSize;

    private int registerValue;

    ErrorFlags(String signalNumber, String signalName, String signalFormat, String interpretation, String registerAddress, ModbusFunctions function, int bytesSize) {
        this.signalNumber = signalNumber;
        this.signalName = signalName;
        this.signalFormat = signalFormat;
        this.interpretation = interpretation;
        this.registerAddress = registerAddress;
        this.function = function;
        this.bytesSize = bytesSize;
    }
}
