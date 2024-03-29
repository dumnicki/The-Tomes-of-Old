package d4rsorc.TTOO.system.worldgen;

import java.util.Random;

import d4rsorc.TTOO.system.init.DimensionRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiCreateWorld;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class WorldTypeTest extends WorldType {

	public WorldTypeTest()
    {
        super(DimensionRegistration.DIM_NAME);
        
        // DEBUG
        System.out.println("Constructing WorldTypeCloud");
    }

    @Override
    public BiomeProvider getBiomeProvider(World world)
    {
        return new BiomeProviderTest();
    }

    @Override
    public IChunkGenerator getChunkGenerator(World world, String generatorOptions)
    {
        return new ChunkGeneratorTest(world);
    }

    @Override
    public int getMinimumSpawnHeight(World world)
    {
        return world.getSeaLevel() + 1;
    }

    @Override
    public double getHorizon(World world)
    {
        return 63.0D;
    }

    @Override
    public double voidFadeMagnitude()
    {
        return 0.03125D;
    }

    @Override
    public boolean handleSlimeSpawnReduction(Random random, World world)
    {
        return false;
    }

    @Override
    public void onGUICreateWorldPress() { }


    @Override
    public int getSpawnFuzz(WorldServer world, net.minecraft.server.MinecraftServer server)
    {
        return Math.max(0, server.getSpawnRadius(world));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void onCustomizeButton(Minecraft mc, GuiCreateWorld guiCreateWorld)
    {
    }

    @Override
    public boolean isCustomizable()
    {
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean hasInfoNotice()
    {
        return true;
    }

    /**
     * Get the height to render the clouds for this world type.
     *
     * @return The height to render clouds at
     */
    @Override
    public float getCloudHeight()
    {
        return 128.0F;
    }

}
