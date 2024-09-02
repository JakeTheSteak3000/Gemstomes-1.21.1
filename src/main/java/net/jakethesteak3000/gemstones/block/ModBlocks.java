package net.jakethesteak3000.gemstones.block;

import net.jakethesteak3000.gemstones.Gemstones;
import net.jakethesteak3000.gemstones.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Gemstones.MOD_ID);

        public static final RegistryObject<Block> SAPPHIRE_BLOCK = registerBlock("sapphire_block",
                () -> new Block(BlockBehaviour.Properties.of()
                        .strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

        public static final RegistryObject<Block> RUBY_BLOCK = registerBlock("ruby_block",
                () -> new Block(BlockBehaviour.Properties.of()
                        .strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

        public static final RegistryObject<Block> TOPAZ_BLOCK = registerBlock("topaz_block",
                () -> new Block(BlockBehaviour.Properties.of()
                        .strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final RegistryObject<Block> JADE_BLOCK = registerBlock("jade_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    private static  <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
