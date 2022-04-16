package com.tistory.preventPutHeadItem;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;

public class Event implements Listener {

    @EventHandler
    public void inventoryClick(InventoryClickEvent e) {
        if (e.getRawSlot() != -999 && e.getCurrentItem() != null && e.getClickedInventory() != null) {
            if (e.getWhoClicked() instanceof Player) {
                Player p = (Player) e.getWhoClicked();
                if (p.getOpenInventory().getType() == InventoryType.CRAFTING){
                    if (e.getRawSlot() == 5 && e.getCursor().getType() == Material.SKULL_ITEM && e.getCursor().getItemMeta().getDisplayName() != null){
                        e.setCancelled(true);
                    }
                    else if ((e.getClick() == ClickType.SHIFT_LEFT || e.getClick() == ClickType.SHIFT_RIGHT) && p.getInventory().getItem(103) == null && e.getCurrentItem().getType() == Material.SKULL_ITEM && e.getCurrentItem().getItemMeta().getDisplayName() != null){
                        if (p.getInventory().getHelmet() == null)
                            e.setCancelled(true);
                    }
                }
            }
        }
    }
}
