package cn.bravedawn.obj.inherit.polymorphic.override.example2;

public class StateCouncilSpecialAllowance extends Income{

    public StateCouncilSpecialAllowance(double income) {
        super(income);
    }

    @Override
    public double getTax() {
        return 0;
    }
}
