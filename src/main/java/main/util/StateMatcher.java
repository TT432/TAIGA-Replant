package main.util;

import com.google.common.base.Predicate;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;


public class StateMatcher implements Predicate<IBlockState> {
    private final IBlockState state;
    private final IProperty property;
    private final Comparable value;

    private StateMatcher(IBlockState state, IProperty property, Comparable value) {
        this.state = state;
        this.property = property;
        this.value = value;
    }

    public static StateMatcher forState(IBlockState state, IProperty property, Comparable value) {
        return new StateMatcher(state, property, value);
    }

    public boolean apply(IBlockState state) {
        if (state != null) {
            if (property != null && value != null)
                return state.getBlock() == this.state.getBlock() && state.getValue(property) == value;
            else
                return state.getBlock() == this.state.getBlock();
        }
        return false;
    }
}
