package moviles.guiass.Enum;

import java.util.HashMap;
import java.util.Map;

public enum MenuOptionsEnum {
    RequisitosPrevios(0),
    DatosDelServicioSocial(1),
    PrimerosPasos(2),
    DondeHacerlo(3),
    PasosSiguientes(4),
    SolicitudServicio(5),
    TarjetaControl(6),
    CartaAsignacion(7),
    CartaCompromiso(8);

    private int selected;
    private static Map map = new HashMap<>();

    private MenuOptionsEnum(int selected) {
        this.selected = selected;
    }

    static {
        for (MenuOptionsEnum option : MenuOptionsEnum.values()) {
            map.put(option.selected, option);
        }
    }

    public static MenuOptionsEnum valueOf(int selected) {
        try {
            return (MenuOptionsEnum) map.get(selected);
        } catch (Exception e) {
            return null;
        }
    }

    public int getValue() {
        return selected;
    }
}
