package bobbb2912.com.docfilexml;

import android.os.AsyncTask;
import android.util.Log;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class XMLParser extends AsyncTask<String, Integer, ArrayList<XMLItem>> {

    ArrayList<XMLItem> content;

    public XMLParser(ArrayList<XMLItem> content) {
        this.content = content;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        content = new ArrayList<>();

    }

    @Override
    protected ArrayList<XMLItem> doInBackground(String... strings) {
        try {
            URL url = new URL(strings[0]);
            InputSource is = new InputSource(url.openStream());
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder bd = dbf.newDocumentBuilder();
            Document document = bd.parse(is);
            NodeList nl = document.getElementsByTagName("employee");
            int length = nl.getLength();
            for(int i = 0; i < length; i++) {
                XMLItem xmlItem = new XMLItem();
                Node currentNode = nl.item(i);
                NodeList nChild = currentNode.getChildNodes();
                int childLength = nChild.getLength();
                for(int j = 0; j < childLength; j++) {
                    Node thisNode = nChild.item(j);
                    String nodeName = thisNode.getNodeName();
                    String nodeValue = thisNode.getNodeValue();
                    if(nodeName.equalsIgnoreCase("id")) {
                        xmlItem.setId(nodeValue);
                    }
                    if(nodeName.equalsIgnoreCase("firstName")) {
                        xmlItem.setFirstName(nodeValue);
                    }
                    if(nodeName.equalsIgnoreCase("lastName")) {
                        xmlItem.setLastName(nodeValue);
                    }
                    if(nodeName.equalsIgnoreCase("photo")) {
                        xmlItem.setPhoto(nodeValue);
                    }

                }
                content.add(xmlItem);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return content;
    }

    @Override
    protected void onPostExecute(ArrayList<XMLItem> array) {
        super.onPostExecute(array);
        String name = content.get(1).getLastName();
        Log.d("last name", name);
    }
}
