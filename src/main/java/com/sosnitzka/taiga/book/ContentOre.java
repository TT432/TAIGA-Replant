package com.sosnitzka.taiga.book;

import com.google.common.collect.Lists;
import slimeknights.mantle.client.book.data.BookData;
import slimeknights.mantle.client.book.data.element.ItemStackData;
import slimeknights.mantle.client.book.data.element.TextData;
import slimeknights.mantle.client.gui.book.GuiBook;
import slimeknights.mantle.client.gui.book.element.BookElement;
import slimeknights.mantle.client.gui.book.element.ElementItem;
import slimeknights.mantle.client.gui.book.element.ElementText;
import slimeknights.tconstruct.library.book.TinkerPage;
import slimeknights.tconstruct.library.client.CustomFontColor;

import java.util.ArrayList;
import java.util.List;


public class ContentOre extends TinkerPage {

    public static final transient int INPUT_X = 110;
    public static final transient int INPUT_Y = 80;

    public static final transient float ITEM_SCALE = 1.5F;

    public String title;
    public int r, g, b;

    public ItemStackData input;
    public TextData[] description;
    public String[] informations;

    @Override
    public void build(BookData book, ArrayList<BookElement> list, boolean rightSide) {
        TextData tdTitle = new TextData(title);
        tdTitle.underlined = true;

        addTitle(list, CustomFontColor.encodeColor(r, g, b) + title, true);

        if (input != null && !input.id.equals("")) {
            list.add(new ElementItem(INPUT_X, INPUT_Y, ITEM_SCALE * 2.5f, input.getItems(), input.action));
        }

        if (description != null && description.length > 0) {
            list.add(new ElementText(0, 15, GuiBook.PAGE_WIDTH, GuiBook.PAGE_HEIGHT - 15, description));
        }

        int h = GuiBook.PAGE_WIDTH / 3 - 10;
        if (informations != null && informations.length > 0) {
            TextData head = new TextData(parent.translate("modifier.informations"));
            head.underlined = true;
            list.add(new ElementText(10, 20 + h, GuiBook.PAGE_WIDTH / 2 - 5, GuiBook.PAGE_HEIGHT - h - 20, head));

            List<TextData> effectData = Lists.newArrayList();
            for (String e : informations) {
                effectData.add(new TextData("\u25CF "));
                effectData.add(new TextData(e));
                effectData.add(new TextData("\n"));
            }

            list.add(new ElementText(10, 30 + h, GuiBook.PAGE_WIDTH / 2 + 5, GuiBook.PAGE_HEIGHT - h - 20, effectData));
        }
    }
}