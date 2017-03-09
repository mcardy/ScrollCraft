package com.mcardy.scrollcraft.block.tile;

import com.mcardy.scrollcraft.ScrollCraft;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;

public class CraftingBlockTile extends TileEntity implements IInventory {

	private ItemStack[] items;
	private String customName;
	
	public CraftingBlockTile() {
		this.items = new ItemStack[this.getSizeInventory()];
		for (int i = 0; i < this.getSizeInventory(); i++) {
			items[i] = ItemStack.EMPTY;
		}
	}
	
	public String getCustomName() {
		return customName;
	}
	
	public void setCustomName(String name) {
		this.customName = name;
	}
	
	@Override
	public String getName() {
		return "container." + ScrollCraft.MODID + "_craftingblock";
	}

	@Override
	public boolean hasCustomName() {
		return customName != null;
	}

	@Override
	public ITextComponent getDisplayName() {
	    return this.hasCustomName() ? new TextComponentString(this.getName()) : new TextComponentTranslation(this.getName());
	}

	@Override
	public int getSizeInventory() {
		return 7;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public ItemStack getStackInSlot(int index) {
		if (index < 0 || index >= this.getSizeInventory())
	        return null;
		for (ItemStack s : items) {
			System.out.println(s);
		}
	    return this.items[index];
	}

	@Override
	public ItemStack decrStackSize(int index, int count) {
        ItemStack itemstack = this.getStackInSlot(index);
        if (itemstack == ItemStack.EMPTY) {
        	return itemstack;
        } else if (itemstack.getCount() <= count) {
            this.setInventorySlotContents(index, ItemStack.EMPTY);
            this.markDirty();
            return itemstack;
        } else {
            itemstack = itemstack.splitStack(count);
            if (this.getStackInSlot(index).getCount() <= 0) {
                this.setInventorySlotContents(index, ItemStack.EMPTY);
            } else {
                this.setInventorySlotContents(index, this.getStackInSlot(index));
            }
            this.markDirty();
            return itemstack;
        }
	}

	@Override
	public ItemStack removeStackFromSlot(int index) {
		ItemStack item = items[index];
		items[index] = ItemStack.EMPTY;
		return item;
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		if (index < 0 || index >= this.getSizeInventory())
	        return;

	    if (stack != null && stack.getCount() > this.getInventoryStackLimit())
	        stack.setCount(this.getInventoryStackLimit());
	        
	    if (stack != null && stack.getCount() == 0)
	        stack = ItemStack.EMPTY;

	    this.items[index] = stack;
	    this.markDirty();		
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUsableByPlayer(EntityPlayer player) {
	    return this.world.getTileEntity(this.getPos()) == this && player.getDistanceSq(this.pos.add(0.5, 0.5, 0.5)) <= 64;
	}

	@Override
	public void openInventory(EntityPlayer player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeInventory(EntityPlayer player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		return true;
	}

	@Override
	public int getField(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setField(int id, int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getFieldCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void clear() {
		for (int i = 0; i < getSizeInventory(); i++) {
			this.setInventorySlotContents(i, ItemStack.EMPTY);
		}
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		compound = super.writeToNBT(compound);
		NBTTagList list = new NBTTagList();
		for (int i = 0; i < getSizeInventory(); i++) {
			if (this.getStackInSlot(i) != null) {
				NBTTagCompound stack = new NBTTagCompound();
				stack.setByte("Slot", (byte)i);
				this.getStackInSlot(i).writeToNBT(stack);
				list.appendTag(stack);
			}
		}
		compound.setTag("Items", list);
		if (this.hasCustomName()) {
			compound.setString("CustomName", this.customName);
		}
		return compound;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		NBTTagList list = compound.getTagList("Items", 10);
		for (int i = 0; i < list.tagCount(); i++) {
			NBTTagCompound stack = list.getCompoundTagAt(i);
			int slot = stack.getByte("Slot") & 255;
			this.setInventorySlotContents(slot, new ItemStack(stack));
		}
		if (compound.hasKey("CustomName", 8)) {
			this.setCustomName(compound.getString("CustomName"));
		}
	}

}
