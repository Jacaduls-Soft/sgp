package enums;

public enum Rol {
    Admin("Admin"),
    Operario("Operario");

    String value;

    Rol(String value) {
        this.value = value;
    }
}
