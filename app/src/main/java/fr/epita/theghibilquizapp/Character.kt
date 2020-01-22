package fr.epita.theghibilquizapp

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class Character() : Parcelable {
    @SerializedName("id")
    var id: String? = null
    @SerializedName("name")
    var name: String? = null
    @SerializedName("gender")
    var gender: String? = null
    @SerializedName("age")
    var age: String? = null
    @SerializedName("eye_color")
    var eyeColor: String? = null
    @SerializedName("hair_color")
    var hairColor: String? = null

    constructor(parcel: Parcel) : this() {
        id = parcel.readString()
        name = parcel.readString()
        gender = parcel.readString()
        age = parcel.readString()
        eyeColor = parcel.readString()
        hairColor = parcel.readString()
    }

    constructor(
        id: String?,
        name: String?,
        gender: String?,
        age: String?,
        eyeColor: String?,
        haiColor: String?
    ) : this() {
        this.id = id
        this.name = name
        this.gender = gender
        this.age = age
        this.eyeColor = eyeColor
        hairColor = haiColor
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(name)
        parcel.writeString(gender)
        parcel.writeString(age)
        parcel.writeString(eyeColor)
        parcel.writeString(hairColor)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Character> {
        override fun createFromParcel(parcel: Parcel): Character {
            return Character(parcel)
        }

        override fun newArray(size: Int): Array<Character?> {
            return arrayOfNulls(size)
        }
    }

}