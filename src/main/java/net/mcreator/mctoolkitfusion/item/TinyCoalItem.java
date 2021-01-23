
package net.mcreator.mctoolkitfusion.item;

@MctoolkitFusionModElements.ModElement.Tag
public class TinyCoalItem extends MctoolkitFusionModElements.ModElement {

	@ObjectHolder("mctoolkit_fusion:tiny_coal")
	public static final Item block = null;

	public TinyCoalItem(MctoolkitFusionModElements instance) {
		super(instance, 194);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MISC).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("tiny_coal");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

	}

}