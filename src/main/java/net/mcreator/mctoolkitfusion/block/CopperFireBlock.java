
package net.mcreator.mctoolkitfusion.block;

import net.minecraft.block.material.Material;

@MctoolkitFusionModElements.ModElement.Tag
public class CopperFireBlock extends MctoolkitFusionModElements.ModElement {

	@ObjectHolder("mctoolkit_fusion:copper_fire")
	public static final Block block = null;

	public CopperFireBlock(MctoolkitFusionModElements instance) {
		super(instance, 208);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(null)).setRegistryName(block.getRegistryName()));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void clientLoad(FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(block, RenderType.getCutout());
	}

	public static class CustomBlock extends Block {

		public CustomBlock() {
			super(

					Block.Properties.create(Material.FIRE).sound(SoundType.GROUND).hardnessAndResistance(0f, 0f).setLightLevel(s -> 15)
							.harvestLevel(0).harvestTool(ToolType.SHOVEL).doesNotBlockMovement().notSolid()
							.setNeedsPostProcessing((bs, br, bp) -> true).setEmmisiveRendering((bs, br, bp) -> true)
							.setOpaque((bs, br, bp) -> false));

			setRegistryName("copper_fire");
		}

		@Override
		public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
			return true;
		}

		@Override
		public boolean isReplaceable(BlockState state, BlockItemUseContext context) {
			return context.getItem().getItem() != this.asItem();
		}

		@Override
		public ItemStack getPickBlock(BlockState state, RayTraceResult target, IBlockReader world, BlockPos pos, PlayerEntity player) {
			return new ItemStack(Blocks.AIR, (int) (1));
		}

		@Override
		public MaterialColor getMaterialColor() {
			return MaterialColor.RED;
		}

		@Override
		public PathNodeType getAiPathNodeType(BlockState state, IBlockReader world, BlockPos pos, MobEntity entity) {
			return PathNodeType.DAMAGE_FIRE;
		}

		@Override
		public PushReaction getPushReaction(BlockState state) {
			return PushReaction.DESTROY;
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {

			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(Blocks.AIR, (int) (0)));
		}

		@Override
		public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean moving) {
			super.onBlockAdded(state, world, pos, oldState, moving);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			world.getPendingBlockTicks().scheduleTick(new BlockPos(x, y, z), this, 10);
		}

		@Override
		public void tick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
			super.tick(state, world, pos, random);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();

				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);

				RestlessSoulFireUpdateTickProcedure.executeProcedure($_dependencies);
			}
			world.getPendingBlockTicks().scheduleTick(new BlockPos(x, y, z), this, 10);
		}

	}

}
