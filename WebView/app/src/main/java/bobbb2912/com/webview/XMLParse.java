package bobbb2912.com.webview;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class XMLParse extends AsyncTask<String, Integer, ArrayList> {

    ArrayList<RSSItem> rssItems;
    Context context;
    ListView lvDanhSach;

    public XMLParse(ArrayList<RSSItem> rssItems, Context context, ListView lvDanhSach) {
        this.rssItems = rssItems;
        this.context = context;
        this.lvDanhSach = lvDanhSach;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        rssItems=new ArrayList<>();
    }

    @Override
    protected ArrayList doInBackground(String... strings) {
        try {
            URL url = new URL(strings[0]);
            InputSource is = new InputSource(url.openStream());
            DocumentBuilderFactory dbf  = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(is);

            NodeList nodeList = document.getElementsByTagName("item");
            int nodeListLength = nodeList.getLength();

            for (int i = 0; i < nodeListLength; i++) {
                RSSItem rssItem = new RSSItem();
                Node currentNode = nodeList.item(i);
                NodeList nChild = currentNode.getChildNodes();
                int childLength = nChild.getLength();
                for (int j = 0; j < childLength; j++) {
                    Node thisNode = nChild.item(j);
                    String nodeName = thisNode.getNodeName();
                    String nodeValue = thisNode.getTextContent();
                    if(nodeValue!=null) {
                        if(nodeName.equalsIgnoreCase("title")) {
                            rssItem.setTitle(nodeValue);
                        }
                        if(nodeName.equalsIgnoreCase("description")) {
                            rssItem.setDescription(nodeValue);
                        }
                        if(nodeName.equalsIgnoreCase("pubDate")) {
                            rssItem.setPubDate(nodeValue);
                        }
                        if(nodeName.equalsIgnoreCase("link")) {
                            rssItem.setLink(nodeValue);
                        }
                    }

                }
                rssItems.add(rssItem);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rssItems;
    }

    @Override
    protected void onPostExecute(ArrayList arrayList) {
        super.onPostExecute(arrayList);

        CustomAdapter adapter = new CustomAdapter(context, rssItems);
        lvDanhSach.setAdapter(adapter);

        lvDanhSach.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(context, ChiTiet.class);
                intent.putExtra("link", rssItems.get(i).getLink());
                context.startActivities(new Intent[]{intent});
            }
        });
    }
}
