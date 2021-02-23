import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sharmila.android.kotlin.flickerimagesearch.R
import com.sharmila.android.kotlin.flickerimagesearch.model.Photo


class PhotolistAdapter(private val context: Context, private val dataSet: List<Photo>) :
        RecyclerView.Adapter<PhotolistAdapter.ViewHolder>() {


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageViewHotel: ImageView

        init {
            // Define click listener for the ViewHolder's View.
            imageViewHotel = view.findViewById(R.id.imageView)
        }
    }


    // Create new views
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.item_grid_image, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
Log.d("******","https://farm${dataSet[position].farm.toString()}.static.flickr.com/${dataSet[position].server}/${dataSet[position].id}_${dataSet[position].secret}.jpg");
       Glide.with(context)
                .load("https://farm${dataSet[position].farm.toString()}.static.flickr.com/${dataSet[position].server}/${dataSet[position].id}_${dataSet[position].secret}.jpg")
                .into(viewHolder.imageViewHotel)

    }

    // Return the size of  dataset
    override fun getItemCount() = dataSet.size

}
