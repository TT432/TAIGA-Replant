package main.util;

import com.google.common.base.Predicate;
import net.minecraft.block.state.IBlockState;


public class StateMatcher implements Predicate<IBlockState> {
    private final IBlockState state;

    private StateMatcher(IBlockState state) {
        this.state = state;
    }

    public static StateMatcher forState(IBlockState state) {
        return new StateMatcher(state);
    }

    public boolean apply(IBlockState state) {
        return state != null && state.getBlock() == this.state.getBlock() && state.getMaterial() == this.state.getMaterial();
    }
}
