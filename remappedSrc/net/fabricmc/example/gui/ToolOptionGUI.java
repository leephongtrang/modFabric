package net.fabricmc.example.gui;

import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WButton;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WLabel;
import io.github.cottonmc.cotton.gui.widget.WToggleButton;
import net.fabricmc.example.Client;
import net.fabricmc.example.Option;
import net.fabricmc.example.Tool;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.Window;
import net.minecraft.text.Text;

import java.util.List;

public class ToolOptionGUI extends LightweightGuiDescription {
    List<Option> option;

    static WToggleButton attackBlockToggle = new WToggleButton(Text.literal("Enable Attack Block"));
    static WToggleButton attackEntityToggle = new WToggleButton(Text.literal("Enable Attack Entity"));
    static WButton button = new WButton(Text.literal("Save"));

    public ToolOptionGUI() {
        getOptions();

        WGridPanel panel = new WGridPanel();
        setRootPanel(panel);
        panel.setSize(355, 200);

        attackBlockToggle.setToggle(Tool.enableAttackBlock);
        attackEntityToggle.setToggle(Tool.enableAttackEntity);
        button.setOnClick(() -> {
           applyNewOptions();
        });

        panel.add(attackBlockToggle, 1, 1);
        panel.add(attackEntityToggle, 1, 2);
        panel.add(button, 2,4);
    }

    void getOptions() {
        option = Client.option;
    }

    void applyNewOptions() {
        Client.option.get(0).value = attackBlockToggle.getToggle();
        Client.option.get(1).value = attackEntityToggle.getToggle();

        Tool.setOption();
        ToolOptionFile.updateFile(Client.option);
    }
}
