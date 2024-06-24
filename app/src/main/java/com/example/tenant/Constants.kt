package com.example.tenant

import com.example.tenant.model.JobCard

object Constants {
    fun getJobDetail(): ArrayList<JobCard> {
        val jobList = ArrayList<JobCard>()
        jobList.add(
            JobCard(

                R.string.str_job_1218923,
                R.string.str_february_18,
                R.string.large_text,
                R.drawable.ic_approval,
                R.string.str_approval_pending,
                R.string.str_show_details
            )
        )

        jobList.add(
            JobCard(

                R.string.str_job_1218923,
                R.string.str_february_18,
                R.string.large_text,
                R.drawable.ic_rejected,
                R.string.str_approval_pending,
                R.string.str_show_details
            )
        )

        jobList.add(
            JobCard(

                R.string.str_job_1218923,
                R.string.str_february_18,
                R.string.large_text,
                R.drawable.ic_approval,
                R.string.str_approval_pending,
                R.string.str_show_details
            )
        )

        jobList.add(
            JobCard(

                R.string.str_job_1218923,
                R.string.str_february_18,
                R.string.large_text,
                R.drawable.ic_rejected,
                R.string.str_approval_pending,
                R.string.str_show_details
            )
        )

        jobList.add(
            JobCard(

                R.string.str_job_1218923,
                R.string.str_february_18,
                R.string.large_text,
                R.drawable.ic_rejected,
                R.string.str_approval_pending,
                R.string.str_show_details
            )
        )

        return jobList
    }
}
