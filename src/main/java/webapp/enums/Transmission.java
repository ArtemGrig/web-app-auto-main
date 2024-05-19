package webapp.enums;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Transmission {
    AUTOMATIC("Автоматическая коробка передач"),
    MANUAL("Механическая коробка передач"),
    ROBOT("Роботизированная коробка передач"),
    VARIABLE("Вариативная коробка передач");

    private final String description;
}

