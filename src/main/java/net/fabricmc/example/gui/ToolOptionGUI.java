package net.fabricmc.example.gui;

import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WLabel;
import io.github.cottonmc.cotton.gui.widget.WToggleButton;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.Window;
import net.minecraft.text.Text;

public class ToolOptionGUI extends LightweightGuiDescription {
    String text = "";

    public ToolOptionGUI() {
        getOptions();

        WGridPanel panel = new WGridPanel();
        setRootPanel(panel);
        panel.setSize(355, 200);

        WLabel attackBlockLabel = new WLabel(Text.literal("Enable Attack Block"));
        WToggleButton attackBlockToggle = new WToggleButton();
        WLabel attackEntityLabel = new WLabel(Text.literal("Enable Attack Entity"));
        WToggleButton attackEntityToggle = new WToggleButton();

        panel.add(attackBlockToggle, 1, 1);
        panel.add(attackBlockLabel, 3, 1);
        panel.add(attackEntityToggle, 1, 2);
        panel.add(attackEntityLabel, 3, 2);

        WLabel tl = new WLabel(Text.literal(text));
        panel.add(tl, 5, 5);
    }

    void getOptions() {
        text = ToolOptionFile.getFileOption();
    }
}
