package be.seeseemelk.mockbukkit.block.data;

import static be.seeseemelk.mockbukkit.block.data.BlockDataKey.FACING;
import static be.seeseemelk.mockbukkit.block.data.BlockDataKey.POWERED;
import static be.seeseemelk.mockbukkit.block.data.BlockDataKey.FACE;

import java.util.Set;

import org.bukkit.Material;
import org.bukkit.Tag;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.type.Switch;
import org.jetbrains.annotations.NotNull;

import com.google.common.base.Preconditions;

import be.seeseemelk.mockbukkit.UnimplementedOperationException;

public class ButtonMock extends BlockDataMock implements Switch
{

	/**
	 * Constructs a new {@link ButtonMock} for the provided {@link Material}. Only
	 * supports materials in {@link Tag#BUTTONS}
	 *
	 * @param type The material this data is for.
	 */
	public ButtonMock(@NotNull Material type)
	{
		super(type);
		checkType(type, Tag.BUTTONS);
		this.set(FACE, AttachedFace.WALL);
		this.set(FACING, BlockFace.NORTH);
		this.set(POWERED, false);
	}

	@Override
	public boolean isPowered()
	{
		return super.get(POWERED);
	}

	@Override
	public void setPowered(boolean powered)
	{
		super.set(POWERED, powered);
	}

	@Override
	public @NotNull AttachedFace getAttachedFace()
	{
		return super.get(FACE);
	}

	@Override
	public void setAttachedFace(@NotNull AttachedFace face)
	{
		Preconditions.checkNotNull(face, "AttachedFace cannot be null");
		super.set(FACE, face);
	}

	@Override
	public @NotNull BlockFace getFacing()
	{
		return super.get(FACING);
	}

	@Override
	public void setFacing(@NotNull BlockFace facing)
	{
		Preconditions.checkNotNull(facing, "BlockFace cannot be null");
		Preconditions.checkArgument(getFaces().contains(facing), "Invalid face. Must be one of " + getFaces());
		super.set(FACING, facing);
	}

	@Override
	public @NotNull Set<BlockFace> getFaces()
	{
		return Set.of(BlockFace.SOUTH, BlockFace.EAST, BlockFace.NORTH, BlockFace.WEST);
	}

	@Override
	public @NotNull Face getFace()
	{
		throw new UnimplementedOperationException();
	}

	@Override
	public void setFace(@NotNull Face face)
	{
		throw new UnimplementedOperationException();
	}

}
