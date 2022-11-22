package com.example.studentcrime

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class DetailFragment : Fragment() {
  private var crime: Crime? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    assignReceivedCrime()
  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_detail, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    setViewParams(view)
  }

  private fun assignReceivedCrime() {
    crime = arguments?.getParcelable("crime", Crime::class.java)
  }

  private fun setViewParams(view: View) {
    setTitle(view)
    setStudentIndex(view)
    setStatus(view)
    setDescription(view)
  }

  private fun setTitle(view: View) {
    val titleTextView: TextView = view.findViewById(R.id.fragmentDetailsTitle)
    titleTextView.text = crime?.title
  }

  private fun setStudentIndex(view: View) {
    val studentIndexTextView: TextView =
      view.findViewById(R.id.fragmentDetailsStudentIndex)
    studentIndexTextView.text = crime?.studentIndex.toString()
  }

  private fun setStatus(view: View) {
    val statusTextView: TextView = view.findViewById(R.id.fragmentDetailsStatus)
    var statusText = "Sprawa w toku"
    if (crime?.isSolved == true) {
      statusText = "Sprawa zakończona"
    }
    statusTextView.text = statusText
  }

  private fun setDescription(view: View) {
    val descriptionTextView: TextView =
      view.findViewById(R.id.fragmentDetailsDescription)
    descriptionTextView.text = crime?.description
  }
}