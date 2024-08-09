package com.example.tenant

import android.content.Context
import com.example.tenant.model.JobCard
import com.example.tenant.model.RecentModel

object Constants {
    fun getJobDetail(context: Context): ArrayList<JobCard> {
        val jobList = ArrayList<JobCard>()
        jobList.add(
            JobCard(
                context.getString(R.string.str_job_1218923),
                context.getString(R.string.str_february_18),
                context.getString(R.string.large_text),
                R.drawable.ic_approval,
                context.getString(R.string.str_approval_pending),
                context.getString(R.string.str_show_details)
            )
        )
        jobList.add(
            JobCard(
                context.getString(R.string.str_job_1218923),
                context.getString(R.string.str_february_18),
                context.getString(R.string.large_text),
                R.drawable.ic_approval,
                context.getString(R.string.str_approval_pending),
                context.getString(R.string.str_show_details)
            )
        )
        jobList.add(
            JobCard(
                context.getString(R.string.str_job_1218923),
                context.getString(R.string.str_february_18),
                context.getString(R.string.large_text),
                R.drawable.ic_approval,
                context.getString(R.string.str_approval_pending),
                context.getString(R.string.str_show_details)
            )
        )
        jobList.add(
            JobCard(
                context.getString(R.string.str_job_1218923),
                context.getString(R.string.str_february_18),
                context.getString(R.string.large_text),
                R.drawable.ic_approval,
                context.getString(R.string.str_approval_pending),
                context.getString(R.string.str_show_details)
            )
        )
        jobList.add(
            JobCard(
                context.getString(R.string.str_job_1218923),
                context.getString(R.string.str_february_18),
                context.getString(R.string.large_text),
                R.drawable.ic_rejected,
                context.getString(R.string.str_rejected_by_owner),
                context.getString(R.string.str_show_details)
            )
        )
        return jobList
    }

    fun getRecentItem(context: Context): List<RecentModel> {
        val recentList = ArrayList<RecentModel>()
        recentList.add(
            RecentModel(
                "3874982",
                "Light Replacement",
                "Completed",
                "bbb",
                R.color.red,
                "June 26, 2024",
                "1:30 PM"
            )
        )
        recentList.add(
            RecentModel(
                "3874982",
                "Light Replacement",
                "Completed",
                "bbb",
                R.color.blue_dark,
                "June 26, 2024",
                "1:30 PM"
            )
        )
        recentList.add(
            RecentModel(
                "3874982",
                "Light Replacement",
                "Completed",
                "bbb",
                R.color.red,
                "June 26, 2024",
                "1:30 PM"
            )
        )
        recentList.add(
            RecentModel(
                "3874982",
                "Light Replacement",
                "Completed",
                "bbb",
                R.color.blue,
                "June 26, 2024",
                "1:30 PM"
            )
        )
        recentList.add(
            RecentModel(
                "3874982",
                "Light Replacement",
                "Completed",
                "bbb",
                R.color.blue_dark,
                "June 26, 2024",
                "1:30 PM"
            )
        )
        recentList.add(
            RecentModel(
                "3874982",
                "Light Replacement",
                "Completed",
                "bbb",
                R.color.gray,
                "June 26, 2024",
                "1:30 PM"
            )
        )
        recentList.add(
            RecentModel(
                "3874982",
                "Light Replacement",
                "Completed",
                "bbb",
                R.color.blue_dark,
                "June 26, 2024",
                "1:30 PM"
            )
        )
        recentList.add(
            RecentModel(
                "3874982",
                "Light Replacement",
                "Completed",
                "bbb",
                R.color.red,
                "June 26, 2024",
                "1:30 PM"
            ),
        )
        return recentList
    }

    fun getnewRequistItem(context: Context): List<RecentModel> {
        val recentList = ArrayList<RecentModel>()
        recentList.add(
            RecentModel(
                "By: Flat 234, Building 405, District, City",
                "",
                "Completed",
                "Your Approval is Pending ",
                R.color.red,
                "June 26, 2024",
                "1:30 PM"
            )
        )
        recentList.add(
            RecentModel(
                "By: Flat 234, Building 405, District, City",
                "",
                "Completed",
                "Your Approval is Pending ",
                R.color.red,
                "June 26, 2024",
                "1:30 PM"
            )
        )
        recentList.add(
            RecentModel(
                "By: Flat 234, Building 405, District, City",
                "",
                "Completed",
                "Your Approval is Pending ",
                R.color.red,
                "June 26, 2024",
                "1:30 PM"
            )
        )
        recentList.add(
            RecentModel(
                "By: Flat 234, Building 405, District, City",
                "",
                "Completed",
                "Your Approval is Pending ",
                R.color.red,
                "June 26, 2024",
                "1:30 PM"
            )
        )
        recentList.add(
            RecentModel(
                "By: Flat 234, Building 405, District, City",
                "",
                "Completed",
                "Your Approval is Pending ",
                R.color.red,
                "June 26, 2024",
                "1:30 PM"
            )
        )
        recentList.add(
            RecentModel(
                "By: Flat 234, Building 405, District, City",
                "",
                "Completed",
                "Your Approval is Pending ",
                R.color.red,
                "June 26, 2024",
                "1:30 PM"
            )
        )
        recentList.add(
            RecentModel(
                "3874982",
                "Light Replacement",
                "Completed",
                "bbb",
                R.color.red,
                "June 26, 2024",
                "1:30 PM"
            )
        )
        recentList.add(
            RecentModel(
                "3874982",
                "Light Replacement",
                "Completed",
                "bbb",
                R.color.red,
                "June 26, 2024",
                "1:30 PM"
            ),
        )
        return recentList
    }
}