package me.emiel.lockdupkeys.GUI;

import me.emiel.lockdupkeys.Lockdupkeys;
import me.emiel.lockdupkeys.Model.KeyCard;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.Arrays;
import java.util.HashMap;

public class LevelSelectGUI {
        private Inventory inv;
        private static HashMap<HumanEntity, Block> openUI;

        public static void removeFromOpen(HumanEntity e){
            openUI.remove(e);
        }

        public static void clicked(HumanEntity p, int rawSlot) {
            Block b = openUI.get(p);
            PersistentDataContainer pcb = Lockdupkeys.getCustomData(b);
            NamespacedKey key = new NamespacedKey(Lockdupkeys.get_instance(), KeyCard.getPcbName());
            int level = 0;
            switch (rawSlot){
                case 2:
                    pcb.set(key, PersistentDataType.INTEGER, 1);
                    p.closeInventory();
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lDoor &f&l|&r&2 Set this door to a level " + 1));
                    break;
                case 3:
                    pcb.set(key, PersistentDataType.INTEGER, 2);
                    p.closeInventory();
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lDoor &f&l|&r&2 Set this door to a level " + 2));

                    break;
                case 4:
                    pcb.set(key, PersistentDataType.INTEGER, 3);
                    p.closeInventory();
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lDoor &f&l|&r&2 Set this door to a level " + 3));

                    break;
                case 5:
                    pcb.set(key, PersistentDataType.INTEGER, 4);
                    p.closeInventory();
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lDoor &f&l|&r&2 Set this door to a level " + 4));

                    break;
                case 6:
                    pcb.set(key, PersistentDataType.INTEGER, 5);
                    p.closeInventory();
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lDoor &f&l|&r&2 Set this door to a level " + 5));

                    break;
            }

        }

        // You can call this whenever you want to put the items in
        public void initializeItems(Block block) {

        }

        // Nice little method to create a gui item with a custom name, and description
        protected ItemStack createGuiItem(final Material material, final String name, final boolean addCellId, final String... lore) {
            final ItemStack item = new ItemStack(material, 1);
            final ItemMeta meta = item.getItemMeta();

            // Set the name of the item
            meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));

            for (int i = 0; i < lore.length; i++) {
                String str = lore[i];
                str = ChatColor.translateAlternateColorCodes('&', str);
                lore[i] = str;
            }

            // Set the lore of the item
            meta.setLore(Arrays.asList(lore));

            item.setItemMeta(meta);

            return item;
        }

        // You can open the inventory with this
        public void openInventory(final HumanEntity ent, Block block) {
            // Create a new inventory, with no owner (as this isn't a real inventory), a size of nine, called example
            inv = Bukkit.createInventory(null, 9, "&bWhat level door?");
            // Put the items into the inventory
            initializeItems(block);
            openUI.put(ent, block);
            ent.openInventory(inv);
        }




}
