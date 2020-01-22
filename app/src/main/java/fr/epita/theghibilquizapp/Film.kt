package fr.epita.theghibilquizapp

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class Film() : Parcelable {
    @SerializedName("id")
    var id: String? = null
    @SerializedName("title")
    var title: String? = null
    @SerializedName("description")
    var description: String? = null
    @SerializedName("director")
    var director: String? = null
    @SerializedName("producer")
    var producer: String? = null
    @SerializedName("release_date")
    var releaseDate: String? = null
    @SerializedName("rt_score")
    var score: String? = null

    constructor(parcel: Parcel) : this() {
        id = parcel.readString()
        title = parcel.readString()
        description = parcel.readString()
        director = parcel.readString()
        producer = parcel.readString()
        releaseDate = parcel.readString()
        score = parcel.readString()
    }

    constructor(
        id: String?,
        title: String?,
        description: String?,
        director: String?,
        producer: String?,
        releaseDate: String?,
        score: String?
    ) : this() {
        this.id = id
        this.title = title
        this.description = description
        this.director = director
        this.producer = producer
        this.releaseDate = releaseDate
        this.score = score
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(title)
        parcel.writeString(description)
        parcel.writeString(director)
        parcel.writeString(producer)
        parcel.writeString(releaseDate)
        parcel.writeString(score)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Film> {
        override fun createFromParcel(parcel: Parcel): Film {
            return Film(parcel)
        }

        override fun newArray(size: Int): Array<Film?> {
            return arrayOfNulls(size)
        }
    }
}