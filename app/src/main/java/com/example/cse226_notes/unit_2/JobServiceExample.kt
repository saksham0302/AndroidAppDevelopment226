package com.example.cse226_notes.unit_2

import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.core.content.getSystemService
import com.example.cse226_notes.R

class JobServiceExample : AppCompatActivity() {

    private var jobScheduler: JobScheduler? = null
    private lateinit var startJob: Button
    private lateinit var stopJob: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_job_service_example)

        startJob = findViewById(R.id.startJob)
        stopJob = findViewById(R.id.stopJob)

        startJob.setOnClickListener {

            jobScheduler = getSystemService(JOB_SCHEDULER_SERVICE) as JobScheduler
            val componentName = ComponentName(this, JobServiceDemo::class.java)

            val builder = JobInfo.Builder(123, componentName)
            builder.setMinimumLatency(1000)
            builder.setOverrideDeadline(3000)
            builder.setPersisted(true)
            builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
            builder.setRequiresCharging(false)
            jobScheduler!!.schedule(builder.build())
        }

        stopJob.setOnClickListener {

            if (jobScheduler != null) {

                jobScheduler!!.cancel(123)
                jobScheduler = null
                Toast.makeText(this, "Job Cancelled", Toast.LENGTH_LONG).show()
            }
        }
    }
}