package dao;

import dto.VendingMachineItem;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;


public class VendingMachineDaoFileImpl implements VendingMachineDao {
    private Map<String, VendingMachineItem> vendorMachine = new HashMap<>();
    public static final String AUDIT_FILE = "audit.txt";
    private final String  ITEM_LIST_PATH = "src/itemList";
    private final String DELIMITER = "::";

    public VendingMachineDaoFileImpl() {

    }

    @Override
    public List<VendingMachineItem> getVendingMachineInventory() throws VendingMachinePersistenceException {
        loadItems();
        return new ArrayList<>(vendorMachine.values());
    }

    @Override
    public VendingMachineItem getVendingMachineItem(String name) throws VendingMachinePersistenceException {
        loadItems();
        return vendorMachine.get(name);
    }

    @Override
    public void updateVendingMachineItem(String name, VendingMachineItem item) throws VendingMachinePersistenceException {
        loadItems();
        vendorMachine.replace(name, item);
        writeItems();
    }


    private VendingMachineItem unmarshallItem(String itemAsText)
    {
        String[] itemAsTokens = itemAsText.split(DELIMITER);
        String name = itemAsTokens[0];
        VendingMachineItem itemFromFile=new VendingMachineItem(name);
        itemFromFile.setCost(new BigDecimal(itemAsTokens[1]));
        itemFromFile.setAmount(Integer.parseInt(itemAsTokens[2]));
        return itemFromFile;
    }

    private void loadItems() throws VendingMachinePersistenceException {
        Scanner scanner;
        try {
            scanner= new Scanner(new BufferedReader(new FileReader(ITEM_LIST_PATH)));
        } catch (FileNotFoundException e) {
            throw new VendingMachinePersistenceException("Could not load item list");
        }
        String currentLine;
        VendingMachineItem currentItem;
        while(scanner.hasNext()){
            currentLine= scanner.nextLine();
            currentItem=unmarshallItem(currentLine);
            vendorMachine.put(currentItem.getName(), currentItem);
        }
        scanner.close();
    }

    private String marshallItem(VendingMachineItem item){
        String itemAsText= item.getName()+DELIMITER;
        itemAsText+=item.getCost()+DELIMITER;
        itemAsText+=item.getAmount()+DELIMITER;
        return itemAsText;
    }
    private void writeItems() throws VendingMachinePersistenceException {
        PrintWriter out;
        try{
            out=new PrintWriter(new FileWriter(ITEM_LIST_PATH));
        }catch(IOException e){
            throw new VendingMachinePersistenceException("Could not save items to file");
        }
        String itemAsText;
        List<VendingMachineItem> itemList = getVendingMachineInventory();
        for(VendingMachineItem currentItem: itemList){
            itemAsText = marshallItem(currentItem);
            out.println(itemAsText);
            out.flush();
        }
        out.close();
    }
}