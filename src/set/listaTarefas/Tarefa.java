package set.listaTarefas;

import java.util.Objects;

public class Tarefa {

    private String  desc;
    private boolean status;

    public Tarefa(String desc) {
        this.desc = desc;

    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tarefa tarefa)) return false;
        return Objects.equals(getDesc(), tarefa.getDesc());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDesc());
    }

    @Override
    public String toString() {
        return "Tarefa{" +
                "desc='" + desc + '\'' +
                ", status=" + status +
                '}';
    }
}
